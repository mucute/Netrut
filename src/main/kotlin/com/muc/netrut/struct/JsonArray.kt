package com.muc.netrut.struct

import com.alibaba.fastjson2.JSONArray
import com.alibaba.fastjson2.JSONObject

class JsonArray(
    private var string: String
) {
    constructor() : this("{}")

    private val jsonObject = JSONArray.parseArray(string)


    fun <T> get(index: Int): T {
        return jsonObject[index] as T
    }

    fun getString(index: Int) {
        jsonObject.getString(index)
    }

    fun getInt(index: Int) {
        jsonObject.getInteger(index)
    }

    fun getShort(index: Int) {
        jsonObject.getShort(index)
    }

    fun getJsonMap(index: Int) {
        jsonObject.getJSONObject(index)
    }

    fun getJsonArray(index: Int) {
        jsonObject.getJSONArray(index)
    }

    fun getBoolean(index: Int) {
        jsonObject.getBoolean(index)
    }

    fun getDouble(index: Int) {
        jsonObject.getDouble(index)
    }

    fun getFloat(index: Int) {
        jsonObject.getFloat(index)
    }

    override fun toString(): String {
        return string
    }
}