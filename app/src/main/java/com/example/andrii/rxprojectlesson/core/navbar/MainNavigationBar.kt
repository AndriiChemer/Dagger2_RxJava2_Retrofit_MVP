package com.example.andrii.rxprojectlesson.core.navbar

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.example.andrii.rxprojectlesson.R

class MainNavigationBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.main_navigation_bar, this, true)
        setupListener()
    }

    private fun setupListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
