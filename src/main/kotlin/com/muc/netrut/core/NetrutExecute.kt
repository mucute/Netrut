package com.muc.netrut.core

import com.muc.netrut.annotation.request.Get
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Method

class NetrutExecute{

    private val okHttpClient: OkHttpClient = OkHttpClient()
    lateinit var request: Request
    var success: ((Response) -> Unit)? = null
    var error: ((IOException) -> Unit)? = null


    fun start(): NetrutExecute {
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                error?.invoke(e)
            }

            override fun onResponse(call: Call, response: Response) {
                success?.invoke(response)

            }

        })
        return this
    }
}