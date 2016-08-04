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
	 * �����û��������룬���е�¼��֤��
	 * ע�⣺���ص�User������û��ExtendInfo����Ҫ����populateExtendInfo����������䡣
	 * 
	 * @param name
	 *            �û���
	 * @param password
	 *            ����password��δ���ܵ���ʽ
	 * @return ��֤ͨ�����ظ��û����󣬷��򷵻ؿ�
	 */
	public User login(String name, String password);

	/**
	 * ���ָ��User��ExtendInfo��
	 * @param user
	 * @param flags
	 * 			ͨ����־ָ���Ƿ����ָ�����ԡ�
	 *            1:History
	 *            2:Favorite
	 *            4:Deliveries
	 *            8:Coupons
	 *          ���ϱ�־����ͨ����λ�������ϡ�
	 *          �磺
	 *          flags = ��1 | 2 | 8��
	 *          ��ִ�к�UserExtendInfo��History��Favorite��Coupons����ӵ�����ݣ���DeliveriesΪ��
	 */
	public void populateExtendInfo(User user, int flags);
}
