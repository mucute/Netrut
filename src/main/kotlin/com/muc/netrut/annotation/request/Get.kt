package com.muc.netrut.annotation.request

@Target(AnnotationTarget.ANNOTATION_CLASS,AnnotationTarget.FUNCTION, AnnotationTarget.CLASS,AnnotationTarget.TYPE)
@Retention()
annotation class Get(val url:String)