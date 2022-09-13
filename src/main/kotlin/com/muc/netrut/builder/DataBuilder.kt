package com.muc.netrut.builder

import com.muc.netrut.annotation.Param
import com.muc.netrut.core.Data
import com.muc.netrut.core.ParamMap
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType

class DataBuilder<T> {

    private lateinit var method: Method
    private lateinit var arguments: Array<Any>
    private lateinit var baseUrl: String

    fun setBaseUrl(baseUrl: String): DataBuilder<T> {
        this.baseUrl = baseUrl
        return this
    }

    fun setMethod(method: Method): DataBuilder<T> {
        this.method = method
        return this
    }

    fun setArguments(rgs: Array<Any>): DataBuilder<T> {
        this.arguments = rgs
        return this
    }

    fun build(): Data<T> {
        val type = (method.genericReturnType as ParameterizedType).actualTypeArguments[0]
        val clazz = type as Class<*>
        val paramBuilder = ParamMap().apply {
            if (arguments[0] is Map<*, *>) {
                val map = arguments[0] as Map<*, *>
                map.forEach { (any, u) ->
                    add(any.toString(), u.toString())
                }
            } else {
                for (index in arguments.indices) {
                    if (method.parameters[index].isAnnotationPresent(Param::class.java)) {
                        add(method.parameters[index].getAnnotation(Param::class.java).name, arguments[index].toString())
                    } else add(method.parameters[index].name.toString(), arguments[index].toString())
                }
            }
        }
        return Data(baseUrl, method, clazz.getConstructor().newInstance(), paramBuilder)
    }
}