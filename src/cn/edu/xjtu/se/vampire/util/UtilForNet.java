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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author aetf
 */
public class UtilForNet {

    public static String getParamString(HttpServletRequest request, String name) {
        String str = request.getParameter(name);
        return str == null ? new String() : str.trim();
    }

    public static int getParamInt(HttpServletRequest request, String name) {
        String str = request.getParameter(name);
        return str == null ? 0 : Integer.valueOf(str);
    }

    public static Date getParamDate(HttpServletRequest request, String name, String fmt) {
        String str = request.getParameter(name);
        Date rt = null;
        try {
            rt = new SimpleDateFormat(fmt).parse(str);
        } catch (Exception e) {
        }
        return rt == null ? new Date() : rt;
    }
    
    public static Date getParamDate(HttpServletRequest request, String name) {
        return getParamDate(request, name, "yyyy-M-d H:m:s");
    }

    public static boolean isEmptyParam(HttpServletRequest request, String name) {
        String str = request.getParameter(name);
      
        return isEmptyString(str);
    }
    
    public static boolean isEmptyString(String str) {
    	return str == null || str.trim().isEmpty();
    }

    public static StringBuilder addParameter(StringBuilder url, Map<String, String> para) {
        Set<String> keys = para.keySet();
        int cnt = 0;
        for (String key : keys) {
            if (!para.get(key).isEmpty()) {
                url.append(cnt == 0 ? "?" : "&");
                url.append(key).append("=").append(para.get(key));
                cnt++;
            }
        }
        return url;
    }

    /**
     * Returns a context-relative path for the request, including the query
     * string, if any.
     */
    public static String getContextRelativeURI(HttpServletRequest request) {
        int ctxPathLength = request.getContextPath().length();
        String requestURI = request.getRequestURI();
        StringBuilder uri = new StringBuilder(requestURI.substring(ctxPathLength));
        String query = request.getQueryString();
        if (query != null) {
            uri.append("?").append(query);
        }
        return uri.toString();
    }
}

