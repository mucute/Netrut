package com.muc.netrut.core

import com.muc.netrut.annotation.RequestMapping
import java.lang.reflect.Proxy

object Netrut {
    inline fun <reified T> create(): T {
        if (!T::class.java.isAnnotationPresent(RequestMapping::class.java)) {
            throw Exception("no RequestMapping")
        }
        return Proxy.newProxyInstance(T::class.java.classLoader, arrayOf(T::class.java), MethodProxy<T>(T::class.java.getAnnotation(RequestMapping::class.java).url)) as T
    }

}