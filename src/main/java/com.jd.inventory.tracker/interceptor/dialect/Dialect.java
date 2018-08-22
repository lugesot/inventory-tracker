/*
 * File : Dialect.java
 * date : Sep 18, 2012 9:48:34 AM
 */
package com.jd.inventory.tracker.interceptor.dialect;

import java.util.LinkedHashMap;

public abstract class Dialect {

    public static enum Type {
        MYSQL, ORACLE
    }

    public abstract String getLimitString(String sql, int skipResults, int maxResults);

    public abstract String getCountString(String sql);

    public abstract String getOrderString(String sql, LinkedHashMap<String, String> taskItems);

}
