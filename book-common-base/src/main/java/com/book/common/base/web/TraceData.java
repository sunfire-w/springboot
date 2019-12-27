package com.book.common.base.web;

/**
 * 日志跟踪
 */

public class TraceData {

    /* 用户单次请求ID */
    public static ThreadLocal<Long> traceId = new ThreadLocal<Long>();

    public static ThreadLocal<Long> seqStart = new ThreadLocal<Long>();
}
