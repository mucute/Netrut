package com.muc.netrut.annotation

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.CLASS, AnnotationTarget.TYPE,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention()
annotation class Param(val name: String)