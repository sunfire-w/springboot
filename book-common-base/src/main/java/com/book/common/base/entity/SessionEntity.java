package com.book.common.base.entity;

import java.io.Serializable;

public class SessionEntity implements Serializable {
    private static final long serialVersionUID = 34994541230L;
    private String sid;
    private String version;
    private String source;
    private Object request;

    public SessionEntity() {
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getRequest() {
        return this.request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }
}
