package com.example.testetopi.helpers

import com.airbnb.lottie.LottieAnimationView

class LottieHelper(animation: LottieAnimationView) {

    companion object {
        const val FIRST_FRAME = 10
        const val LAST_FRAME = 60
    }

    init {
        animation.setMinAndMaxFrame(FIRST_FRAME, LAST_FRAME)
    }
}