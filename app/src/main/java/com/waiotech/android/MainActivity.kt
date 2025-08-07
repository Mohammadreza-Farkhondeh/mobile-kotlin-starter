package com.waiotech.android

import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tv =
            TextView(this).apply {
                text = "Hello Android!"
                layoutParams =
                    LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT,
                    )
                textSize = 24f
            }

        setContentView(tv)
    }
}

