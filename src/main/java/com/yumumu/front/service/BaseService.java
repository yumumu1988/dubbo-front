package com.yumumu.front.service;

public interface BaseService<T> {
    Boolean processCommand(T t);
}
