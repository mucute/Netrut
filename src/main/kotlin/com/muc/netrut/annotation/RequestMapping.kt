package com.muc.netrut.annotation

import java.lang.annotation.ElementType

@Target(AnnotationTarget.ANNOTATION_CLASS,AnnotationTarget.FUNCTION, AnnotationTarget.CLASS,AnnotationTarget.TYPE)
@Retention()
annotation class RequestMapping(val url:String)
