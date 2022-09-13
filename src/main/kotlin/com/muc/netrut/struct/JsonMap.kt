package com.muc.netrut.struct

import com.alibaba.fastjson2.JSONArray
import com.alibaba.fastjson2.JSONObject


class JsonMap(
    private var string: String
) {
    constructor() : this("{}")

    private val jsonObject = JSONObject.parseObject(string)


    fun <T> get(key: String): T {
        return jsonObject.get(key) as T
    }

    fun getString(key: String): String {
        return jsonObject.getString(key)
    }

    fun getInt(key: String): Int {
        return jsonObject.getInteger(key)
    }

    fun getShort(key: String): Short {
        return jsonObject.getShort(key)
    }

    fun getJsonMap(key: String): JSONObject {
        return jsonObject.getJSONObject(key)
    }

    fun getJsonArray(key: String): JsonArray {
        return JsonArray(jsonObject.getJSONArray(key).toJSONString())
    }

    fun getBoolean(key: String): Boolean {
        return jsonObject.getBoolean(key)
    }

    fun getDouble(key: String): Double {
        return jsonObject.getDouble(key)
    }

    fun getFloat(key: String): Float {
        return jsonObject.getFloat(key)
    }

    override fun toString(): String {
        return string
    }

}