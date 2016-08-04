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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

/**
 * Represent a pair of a string and an id.
 * @author Aetf <7437103@gmail.com>
 */
public class OnePair implements Identifiable {

    private int m_id;

    private String m_value;

    private String m_table;
    
    private OnePair() {}
    
    public static OnePair Retrive(String table, int id)
    {
    	OnePair op = null;
    	Connection conn = null;
    	PreparedStatement pst = null;
    	ResultSet rs = null;
    	
    	if(table.endsWith("Info")) {
    		// table 减掉info作为列名
        	String colstr = table.substring(0, table.length() - "Info".length());
        	
        	try {
        		conn = JDBCUtil.getConnection();
        		
        		StringBuilder sb = new StringBuilder();
        		sb.append("select ").append(colstr).append(" from ").append(table)
        		.append(" where ID=").append(id);
        		
        		pst = conn.prepareStatement(sb.toString());
        		rs = pst.executeQuery();
        		
        		if(rs.next()) {
        			op = new OnePair();
        			op.setID(id);
        			op.setTableName(table);
        			op.setValue(rs.getString(colstr));        			
        		}
        	} catch (Exception ex) {
        		ex.printStackTrace();
        	} finally {
        		JDBCUtil.closes(rs, pst, conn);
        	}
        	
    	}
    	return op;
    }

    @Override
    public int getID() {
        return m_id;
    }

    @Override
    public void setID(int id) {
        m_id = id;
    }
    
    private void setValue(String val) {
    	m_value = val;
    }
    
    private void setTableName(String val) {
    	m_table = val;
    }

    /**
     * @return the corresponding string value
     */
    public String getValue() {
        return m_value;
    }

    /**
     * @return the table name which saves the strings
     */
    public String getTableName() {
        return m_table;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if( obj != null && obj instanceof OnePair) {
    		 OnePair op = (OnePair) obj;
    		 return op.getID() == this.getID()
    				 && op.getTableName().equals(this.getTableName())
    				 && op.getValue().equals(this.getValue());
    	}
    	
    	return false;
    }
    
    @Override
    public int hashCode() {
    	return m_table.hashCode() + m_value.hashCode() + m_id * 29;
    }

}
