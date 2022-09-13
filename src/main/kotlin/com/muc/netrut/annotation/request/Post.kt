package com.muc.netrut.annotation.request

@Target(AnnotationTarget.ANNOTATION_CLASS,AnnotationTarget.FUNCTION, AnnotationTarget.CLASS,AnnotationTarget.TYPE)
@Retention()
annotation class Post(val url:String)