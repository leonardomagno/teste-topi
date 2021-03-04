package com.example.testetopi.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.*
import java.lang.annotation.Retention
import java.lang.annotation.Target
import kotlin.reflect.KClass

@MapKey
@kotlin.annotation.Target(AnnotationTarget.FUNCTION)
annotation class ViewModelKey(val value : KClass<out ViewModel>)
