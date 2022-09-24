package com.muc.netrut.core

import java.io.File

object ParamChecker {
    fun existsFileType(parameterTypes: Array<Class<*>>): Boolean {

        for (parameterType in parameterTypes) {
            if (parameterType.isAssignableFrom(File::class.java)) {
                return true
            }
        }
        return false
    }
}