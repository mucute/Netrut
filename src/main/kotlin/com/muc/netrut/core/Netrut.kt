package com.muc.netrut.core

import com.muc.netrut.annotation.BaseUrl
import java.lang.reflect.Proxy

object Netrut {
    /**
     * 默认实例化方法
     */
    inline fun <reified T> create(): T {
        if (!T::class.java.isAnnotationPresent(BaseUrl::class.java)) {
            throw Exception("no RequestMapping")
        }
        return Proxy.newProxyInstance(
            T::class.java.classLoader,
            arrayOf(T::class.java),
            MethodProxy<T>(T::class.java.getAnnotation(BaseUrl::class.java).url)
        ) as T
    }

    /**
     * 使用此实例化方法不必配置@BaseUrl注解
     */
    inline fun <reified T> create(url: String): T {
        return Proxy.newProxyInstance(T::class.java.classLoader, arrayOf(T::class.java), MethodProxy<T>(url)) as T
    }


}