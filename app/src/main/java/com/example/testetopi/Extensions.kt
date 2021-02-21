package com.example.testetopi

import android.view.View

// >>>>>> VIEW RELATED EXTENSIONS <<<<<

fun View?.visible(){
    this?.apply {
        visibility = View.VISIBLE
    }
}

fun View?.gone(){
    this?.apply {
        visibility = View.GONE
    }
}

fun View?.invisible(){
    this?.apply {
        visibility = View.INVISIBLE
    }
}
