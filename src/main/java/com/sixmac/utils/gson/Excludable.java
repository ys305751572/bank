package com.sixmac.utils.gson;

/**
 * Created by wangbin on 2014/12/1.
 */
public class Excludable {
    /**
     * ����Ҫ���л�����.
     */
    private transient String[] excludeFields;

    /**
     * ����Ҫ���л�����.
     */
    private transient Class[] excludeClasses;

    public void setExcludeFields(String[] excludeFields) {
        this.excludeFields = excludeFields;
    }

    public String[] getExcludeFields() {
        return excludeFields;
    }

    public void setExcludeClasses(Class[] excludeClasses) {
        this.excludeClasses = excludeClasses;
    }

    public Class[] getExcludeClasses() {
        return excludeClasses;
    }
}