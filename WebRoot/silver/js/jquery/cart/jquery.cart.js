/*
 * jQuery.cart   0.3
 * Copyright (c) 2014  Aetf<7437103@gmail.com>
 * Date: 2014-03-08
 * 使用jQuery.cart可以很方便的实现加入购物车效果
 */
 /* global jQuery: true*/
// the semi-colon before function invocation is a safety net against concatenated
// scripts and/or other plugins which may not be closed properly.
;
(function($, window, document, undefined) {
	'use strict';
	// undefined is used here as the undefined global variable in ECMAScript 3 is
	// mutable (ie. it can be changed by someone else). undefined isn't really being
	// passed in so we can ensure the value of it is truly undefined. In ES5, undefined
	// can no longer be modified.

	// window and document are passed through as local variable rather than global
	// as this (slightly) quickens the resolution process and can be more efficiently
	// minified (especially when both are regularly referenced in your plugin).

	// a simple closure trick to convert a function into one with an unchanging this:
	var bindfn = function(func, thisValue) {
		return function() {
			return func.apply(thisValue, arguments);
		}
	};

	// Create the defaults once
	var pluginName = 'cart',
	defaults = {
		addToCartBtn : ".yaes_cart_add_btn",
		cartUrl : "cart.jsp",
		cartIcon : "../images/i_cart.png",

		cartText : "Shopping Cart",
		dollarSign: '$;',

		cartNoGoodsHTML : '<span class="yaes_nogoods_icon"></span><span>No products here...</span>',
		
		mainColor      : '#71b013',
		secondaryColor : '#ff9900',

		// item = { id: 1234, cnt: 2, img: "images/acs.png", data:{}}
		onItemRemoved: function(item) {},

		// !!! Must be set to work properly.
		// item = { id: 1234, cnt: 2, img: "images/acs.png", data:{}}
		// return = {title: 'spring goods', price: '2.34'}
		onItemDirty: function(item) {
			return {
				title: '',
				price: ''
			};
		},
		
		// btn = jQuery object represents the addToCartBtn
		getItemId: function(btn) {
			return btn.attr('yaes-item-id');
		},

		// btn = jQuery object represents the addToCartBtn
		getItemCnt: function(btn) {
			return btn.attr('yaes-item-cnt');
		},

		// btn = jQuery object represents the addToCartBtn
		getItemImg: function(btn) {
			return btn.attr('yaes-item-img');
		},

		// btn = jQuery object represents the addToCartBtn
		getItemData: function(btn) {
			return {price:0};
		},

		// item = { id: 1234, cnt: 2, img: "images/acs.png", data:{}}
		// return = a url points to a detailed page of the item.
		urlFor: function(item) {
			return '#';
		},

		persistentFn: {
			init: function() {
				$.cookie.json = true;
			},

			add: function(item) {
				var list = this.findAll();
				list.push(item);
				this.set(list);
			},

			set: function(list) {
				$.cookie('yaes_cart_item_list', list, {expires: 90, path: '/'});
			},

			delete: function(itemid) {
				var list = this.findAll(),
					itemid = Number(itemid);
				var old;

				for(var i = list.length -1; i>= 0; i--) {
					if(Number(list[i].id) == itemid) {
						old = list[i];
						list.splice(i, 1);
						break;
					}
				}
				this.set(list);
				return old;
			},

			update: function(item) {
				var list = this.findAll();

				for(var i = list.length -1; i>= 0; i--) {
					if(Number(list[i].id) == Number(item.id)) {
						list[i] = item;
					}
				}
				this.set(list);
			},

			find: function(itemId) {
				var list = this.findAll(),
					itemId = Number(itemId);
				for(var i = list.length -1; i>= 0; i--) {
					if(Number(list[i].id) == itemId) {
						return list[i];
					}
				}
			},

			findAll: function() {
				return $.cookie('yaes_cart_item_list') || [];
			}
		}
	};

	// The actual plugin constructor

	function Plugin(element, options) {
		this.element = element;
		this.$el = $(element);
		this.options = $.extend({}, defaults, options);
		this.persist = this.options.persistentFn;
		this._defaults = defaults;
		this._name = pluginName;
		this.init();
	}

	Plugin.prototype = {
		init: function() {
			this.$cbody = $('<a class="yaes_cart_body"></a>');
			this.$icon  = $('<span class="yaes_cart_icon"></span>');
			this.$title = $('<small class="yaes_cart_text"></small>');
			this.$grand = $('<span class="yaes_cart_grand_total"><b></b> '+this.options.dollarSign+'</span>');
			this.$holder = $('<div class="yaes_cart_holder"></div>');
			this.$nogoods = $('<div class="yaes_cart_nogoods"></div>');
			this.$buydiv   = $('<div class="yaes_cart_buy"></div>');
			this.$buybtn = $('<a class="baseBg"></a>');
			this.$num = $('<span class="yaes_cart_num_outter"><span class="yaes_cart_num"></span></span>');
			
			// insert cart div content
			this.$el.addClass('yaes_cart');

			this.$icon.appendTo(this.$cbody);

			this.$num.appendTo(this.$cbody);
			this.$num = this.$num.find('.yaes_cart_num');
			this.$num.text('0');

			this.$title.text(this.options.cartText);
			// this.$title.appendTo(this.$cbody);

			this.$grand.appendTo(this.$cbody);
			this.$grand = this.$grand.find('b');

			this.$cbody.attr('href', this.options.cartUrl);
			this.$cbody.appendTo(this.$el);

			this.$nogoods.addClass("yaes_cart_noremove");
			this.$nogoods.prepend(this.options.cartNoGoodsHTML);
			this.$nogoods.appendTo(this.$holder);

			this.$buybtn.attr('href', this.options.cartUrl);
			this.$buybtn.appendTo(this.$buydiv);

			this.$buydiv.addClass("yaes_cart_noremove");
			this.$buydiv.appendTo(this.$holder);

			this.$holder.appendTo(this.$el);

			// hover effect
			var mc = this.options.mainColor,
				grand = this.$el.find('.yaes_cart_grand_total').add(this.$grand);
			this.$el.hover (function() {
				grand.stop().animate({
					color: '#ffffff',
					backgroundColor: mc
				},150);
			}, function() {
				grand.stop().animate({
					color: mc,
					backgroundColor: '#ffffff'
				},150);
			});

			// bind handlers
			this.$cbody.on('mouseenter.yaes_cart', bindfn(this.hoverInBody, this));
			this.$cbody.on('mouseleave.yaes_cart', bindfn(this.hoverOutBody, this));
			this.$el.on('click.yaes_cart.item', '.yaes_cart_item', bindfn(this.clickOnItem, this));
			this.$el.on('click.yaes_cart.remove', '.yaes_cart_remove', bindfn(this.clickRemove, this));
			$(document).on('click.yaes_cart.add', this.options.addToCartBtn, bindfn(this.clickAdd, this));

			// init persist storage
			this.persist.init();

			// add all items from persist
			var addi = bindfn(this.addItem, this);
			$.each(this.persist.findAll(), function(idx, item){
				addi(item, true);
			});

			this.updateTotal();
		},

		hoverInBody: function(e) {
			this.doDirty($(".yaes_cart_item.yaes_cart_dirty"));
		},

		hoverOutBody: function(e) {

		},

		clickOnItem: function(e) {
			if(!$(e.target).hasClass('yaes_cart_remove')){
				e.stopPropagation();
			}
		},

		clickRemove: function(e) {
			e.stopPropagation();
			var $target = $(e.target),
				$parent = $target.parents('.yaes_cart_item'),				
				itemid  = this.itemIdFromDomList($parent);

			var rmi = bindfn(this.removeItem, this);
			$parent.addClass('yaes_cart_item_removing').slideUp(150,function(){
				rmi(itemid);
			});

			return false;
		},

		clickAdd: function(e) {
			e.stopPropagation();
			var $target = $(e.target).hasClass(this.options.addToCartBtn) ?
								$(e.target)
								: $(e.target).parents(this.options.addToCartBtn),
			    x       = $target.offset().left + 30,
				y       = $target.offset().top + 10,
				X       = this.$cbody.offset().left+this.$cbody.width()/2-$target.width()/2+60,
				Y       = this.$cbody.offset().top,
				item    = this.itemFromClickAdd($target);

			if ($('#yaes_floatOrder').length > 0) {
				$('#yaes_floatOrder').remove();
			}
			$('body').append('<div id="yaes_floatOrder"><img src="'+ item.img +'" width="50" height="50" /></div>');
			var $obj=$('#yaes_floatOrder');
			var addi = bindfn(this.addItem, this);
			if(!$obj.is(':animated')){
				$obj.css({'left': x,'top': y})
					.animate({'left': X,'top': Y-80},500,function() {
					$obj.stop(false, false).animate({'top': Y-20,'opacity':0},500,function(){
						$obj.fadeOut(300,function(){
							$obj.remove();
							addi(item);
						});
					});
				});	
			};

			return false;
		},

		// item = { id: 1234, cnt: 2, img: "images/acs.png", data:{}}
		removeItem: function(itemid) {
			// var $parent = this.$holder.find('.yaes_cart_item');
			var $parent = this.$holder.find('.yaes_cart_item[yaes-item-id="'+itemid+'"]');
			$parent.remove();
			var old = this.persist.delete(itemid);
			this.options.onItemRemoved(old);
			this.updateTotal();
		},

		// item = { id: 1234, cnt: 2, img: "images/acs.png", data:{}}
		addItem: function(item, nopersist) {
			var li = [];
			li.push('<div class="yaes_cart_item yaes_cart_dirty" yaes-item-id="');
			li.push(item.id);
			li.push('"><a href="');
			li.push(this.options.urlFor(item));
			li.push('" title=""><img src="');
			li.push(item.img);
			li.push('" width="50" height="50"/></a>');
			li.push('<div class=yaes_cart_item_text><p>');
			li.push('null');
			li.push('</p><p><span class="left yaes_cart_item_price"><em>');
			li.push(item.data.price.toFixed(2));
			li.push('</em>Yuan</span><span class="right">x');
			li.push('<span class="yaes_cart_item_cnt">');
			li.push(item.cnt);
			li.push('</span>');
			li.push('</span></p></div><div class="baseBg yaes_cart_remove"></div></div>');

			this.$holder.prepend(li.join(' '));
			if(!nopersist)
				this.persist.add(item);
			this.updateTotal();
		},

		// TODO: not implemented here.
		updateItem: function(item) {
			//...
			alert("updateItem not implemented!");
			this.persist.update(item);
			this.updateTotal();
		},

		getItems: function() {
			// no more things to be done here.
			return this.persist.findAll();
		},

		clearItem: function() {
			$.each(this.persist.findAll, function(idx, item){
				this.removeItem(item.id);
			});
		},

		updateTotal: function() {
			var amount = 0, total = 0;
			this.$holder.find('.yaes_cart_item').each(function(idx){
				var cnt = Number($(this).find('.yaes_cart_item_cnt').text());
				var price = Number($(this).find('.yaes_cart_item_price em').text());
				total += price * cnt;
				amount += cnt;
			});

			if(amount > 0) {
				this.$nogoods.hide();
				this.$buydiv.show();
			} else {
				this.$nogoods.show();
				this.$buydiv.hide();
			}

			this.$num.text(amount);
			this.$grand.text(total.toFixed(2));
		},

		doDirty: function($dirtyItem) {
			if($dirtyItem.length <= 0) return;
			
			var op = this.options,
				ps = this.persist,
				idfd = bindfn(this.itemIdFromDomList, this);

			$dirtyItem.each(function(idx, item){
				op.onItemDirty(ps.find(idfd($(this))), $(this));
				$(this).removeClass('yaes_cart_dirty');
			});

			this.updateTotal();
		},

		itemIdFromDomList: function($item) {
			return $item.attr('yaes-item-id');
		},

		itemFromClickAdd: function($target) {
			return {
				id: this.options.getItemId($target),
				img: this.options.getItemImg($target),
				cnt: this.options.getItemCnt($target),
				data: this.options.getItemData($target)
			};
		}
	};


	// A really lightweight plugin wrapper around the constructor,
	// preventing against multiple instantiations
	$.fn[pluginName] = function(option) {
		var args = arguments,
		result;
		
		this.each(function() {
			var $this = $(this),
			data = $.data(this, 'plugin_' + pluginName),
			options = typeof option === 'object' && option;
			if (!data) {
				$this.data('plugin_' + pluginName, (data = new Plugin(this, options)));
			}
			// if first argument is a string, call silimarly named function
			// this gives flexibility to call functions of the plugin e.g.
			//   - $('.dial').plugin('destroy');
			//   - $('.dial').plugin('render', $('.new-child'));
			if (typeof option === 'string') {
				result = data[option].apply(data, Array.prototype.slice.call(args, 1));
			}
		});

		// To enable plugin returns values
		return result || this;
	};

})(jQuery, window, document);