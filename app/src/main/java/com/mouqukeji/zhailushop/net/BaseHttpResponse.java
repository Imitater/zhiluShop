package com.mouqukeji.zhailushop.net;


public class BaseHttpResponse<T> {
    public int code;
    public String message;
    public T data;
}
