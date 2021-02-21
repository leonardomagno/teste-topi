package com.example.testetopi.base

import android.view.View

interface BaseListAdapterInterface {

    interface OnItemClickListener {
        fun onItemClick(position: Int, view: View)
    }

}