package com.example.testetopi.models

import com.example.testetopi.models.enums.ViewStatus

data class ViewData<D> (
    val data: D? = null,
    val viewStatus: ViewStatus
)