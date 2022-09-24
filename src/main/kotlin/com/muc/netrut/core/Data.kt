package com.muc.netrut.core

import com.muc.netrut.annotation.request.Get
import com.muc.netrut.annotation.request.Post
import com.muc.netrut.struct.JsonMap
import okhttp3.Request
import java.io.IOException
import java.lang.reflect.Method


class Data<T>(
    private var url: String,
    private var method: Method,
    private var type: Any,
    private var paramMap: ParamMap,
) {
    private var error: ((IOException) -> Unit)? = null

    fun success(res: (T) -> Unit): Data<T> {

        val builder: Request.Builder = Request.Builder().apply {
            when {
                method.isAnnotationPresent(Get::class.java) -> {
                    url(url + method.getAnnotation(Get::class.java).url + "?" + paramMap.getStringParam())
                    get()
                }

                method.isAnnotationPresent(Post::class.java) -> {
                    url(url + method.getAnnotation(Post::class.java).url)
                    post(paramMap.getFormBody().build())
                }

                else -> {
                    throw Exception("错误的注解绑定")
                }
            }
        }
        val netrutExecute = NetrutExecute()
        netrutExecute.request = builder.build()
        netrutExecute.success = {
            res.invoke(
                when (type) {
                    is String -> {
                        it.body?.string()
                    }

                    is JsonMap -> {
                        val string = it.body!!.string()
                        JsonMap(string)
                    }

                    else -> {
                        throw Exception("error")
                    }
                } as T
            )
        }
        netrutExecute.error = {
            error?.invoke(it)
        }
        netrutExecute.start()
        return this
    }

    fun error(error: (IOException) -> Unit) {
        this.error = error
    }

}