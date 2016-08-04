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

import java.util.Set;

/**
 * A general database accessor interface
 * @author Aetf <7437103@gmail.com>
 * @param <T>
 * The entity class
 */
public interface IDBAccessor<T extends Identifiable> {
    /**
     * Add t to the database.
     * Note: the ID property of t will be ignored!!!
     * @param t
     * @return true if successed
     */
    public boolean add(T t);

    /**
     * Update t, which is in the database.
     * Passing a t that not existing in the database will cause this method to fail.
     * @param t
     * @return true if successed
     */
    public boolean update(T t);

    /**
     * Delete one line in the database, which has exactly the same id.
     * Nonexisting t in the database will cause this method to fail.
     * @param t
     * @return true if successed
     */
    public boolean delete(T t);

    /**
     * Search and return all T in the database according to the constrain key.
     * @param key
     * 格式为 属性名1=值1;属性名2=值2
     * @return
     * All t that satisfy the constrain in a Set.
     */
    public Set<T> select(String key);
}
