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
package cn.edu.xjtu.se.vampire.util;

import cn.edu.xjtu.se.vampire.hibernate.dao.AreaInfoDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.AreaInfo;

/**
 * @author Aetf
 * Created at 2014年3月6日 上午10:22:04
 */
public class AreaCodeHelper {
	public static String getFullString(int areacode) {
		AreaInfoDAO aid = new AreaInfoDAO();
		StringBuilder sb = new StringBuilder();
		
		// 省
		AreaInfo ai = aid.findById(getProvince(areacode));
		sb.append(ai.getArea());
		// 市
		if(!isProvince(areacode)) {
			ai = aid.findById(getCity(areacode));
			sb.append(ai.getArea());
		}
		// 区
		if(isTown(areacode)) {
			ai = aid.findById(areacode);
			sb.append(ai.getArea());
		}
		return sb.toString();
	}
	
	public static int getProvince(int areacode) {
		return areacode - areacode % 10000;
	}
	
	public static int getCity(int areacode) {
		return areacode - areacode % 100;
	}
	
	public static boolean isProvince(int areacode) {
		return areacode % 10000 == 0;
	}
	
	public static boolean isCity(int areacode) {
		return !isProvince(areacode) && (areacode % 100 == 0);
	}
	
	public static boolean isTown(int areacode) {
		return !isProvince(areacode) && !isCity(areacode);
	}
}
