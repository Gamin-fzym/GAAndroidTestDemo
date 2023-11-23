package com.example.gatestdemol

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import com.example.gatestdemol.databinding.ActivityDetailsBinding
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.ColorDrawable
import android.util.TypedValue
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.res.ResourcesCompat

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_details)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = "Hello, World!"
        binding.textView7.text = "text5"

        //1
        val color = ContextCompat.getColor(this, R.color.my_color)
        binding.textView7.setTextColor(color)

        //2
        val redColor = Color.RED
        val customColor = Color.rgb(255, 165, 0) // 使用RGB值
        val argbColor = Color.argb(255, 255, 165, 0) // 使用ARGB值
        binding.textView8.setTextColor(customColor)

        //3
        val drawable = ColorDrawable(Color.parseColor("#FFC107"))
        binding.textView9.setTextColor(drawable.color)

        //4
        val colorStateList = ContextCompat.getColorStateList(this, R.color.my_color_state_list)
        binding.textView10.setTextColor(colorStateList)

        //5
        var color1 = androidx.appcompat.R.attr.colorPrimary
        var color2 = com.google.android.material.R.attr.colorPrimary
        var color3 = androidx.constraintlayout.widget.R.attr.colorPrimary

        val typedValue = TypedValue()
        this.theme.resolveAttribute(color2, typedValue, true)
        val colorPrimary = typedValue.data
        binding.textView12.setTextColor(colorPrimary)

        //6
        val color6 = ResourcesCompat.getColor(resources, R.color.my_color, null)
        binding.textView13.setTextColor(color6)

        //7
        val colorAnimator = ValueAnimator.ofArgb(Color.RED, Color.BLUE)
        colorAnimator.duration = 5000 // 设置动画持续时间（单位：毫秒）
        colorAnimator.interpolator = AccelerateDecelerateInterpolator() // 设置插值器
        colorAnimator.repeatMode = ValueAnimator.REVERSE // 设置重复模式
        colorAnimator.addUpdateListener { animator ->
            val animatedColor = animator.animatedValue as Int
            // 使用 animatedColor
            binding.textView14.setTextColor(animatedColor)
        }
        colorAnimator.start()

        //8
        val colorMatrix = ColorMatrix().apply { setSaturation(0.5f) }
        val filter = ColorMatrixColorFilter(colorMatrix)
        binding.imageView.colorFilter = filter


//        val colorMatrix = ColorMatrix()
//        val contrast = 1.5f // 对比度增加 50%
//        val matrix = floatArrayOf(
//            contrast, 0f, 0f, 0f, 0f,
//            0f, contrast, 0f, 0f, 0f,
//            0f, 0f, contrast, 0f, 0f,
//            0f, 0f, 0f, 1f, 0f
//        )
//        colorMatrix.set(matrix)
//        val colorFilter = ColorMatrixColorFilter(colorMatrix)
//        binding.imageView.colorFilter = colorFilter




        binding.button1.setOnClickListener {
            it.setBackgroundColor(Color.parseColor("#00FF00"))
        }

    }
}