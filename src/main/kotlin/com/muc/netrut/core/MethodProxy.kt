package com.muc.netrut.core

import com.muc.netrut.builder.DataBuilder
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import kotlin.Throws

/**
 * @author muc
 * @CreateData 2022/5/15
 */
class MethodProxy<T>(private val url: String) : InvocationHandler {
    @Throws(Throwable::class)
    override fun invoke(proxy: Any, method: Method, args: Array<Any>?): Any {
        return DataBuilder<T>()
            .setMethod(method)
            .setArguments(args)
            .setBaseUrl(url)
            .build()
    }
}