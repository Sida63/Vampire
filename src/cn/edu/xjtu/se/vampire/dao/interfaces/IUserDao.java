/*
 * Copyright (c) 2014, Aetf <7437103@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package cn.edu.xjtu.se.vampire.dao.interfaces;

import cn.edu.xjtu.se.vampire.entity.User;

/**
 * Database accessor specialized for User
 * 
 * @author Aetf <7437103@gmail.com>
 */
public interface IUserDao extends IDBAccessor<User> {
	/**
	 * 给定用户名与密码，进行登录验证。
	 * 注意：返回的User对象中没有ExtendInfo，需要调用populateExtendInfo方法进行填充。
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            参数password是未加密的形式
	 * @return 验证通过返回该用户对象，否则返回空
	 */
	public User login(String name, String password);

	/**
	 * 填充指定User的ExtendInfo。
	 * @param user
	 * @param flags
	 * 			通过标志指定是否填充指定属性。
	 *            1:History
	 *            2:Favorite
	 *            4:Deliveries
	 *            8:Coupons
	 *          以上标志可以通过按位或进行组合。
	 *          如：
	 *          flags = （1 | 2 | 8）
	 *          则执行后UserExtendInfo的History，Favorite，Coupons属性拥有数据，而Deliveries为空
	 */
	public void populateExtendInfo(User user, int flags);
}
