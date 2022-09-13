package com.muc.netrut.core

import okhttp3.FormBody

class ParamMap {
    //参数表
    private val mParamMap = LinkedHashMap<String, Any>()

    fun add(key: String, value: Any) {
        mParamMap[key] = value
    }

    fun getFormBody() = FormBody.Builder().apply {
        mParamMap.forEach { (key, value) ->
           this.add(key, value.toString())
        }
    }

    fun getStringParam() = StringBuffer().apply {
        mParamMap.onEachIndexed { index, map ->
            append(map.key)
            append("=")
            append(map.value)
            if (index != mParamMap.size - 1) append("&")
        }
    }.toString()
}