package com.example.taskgmailuidesign.presentation

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView

//fun AppCompatTextView.shader(radius: Float, startColor: Int, endColor: Int) {
//    val shader = LinearGradient(
//        0f,
//        0f,
//        0f,
//        radius,
//        startColor,
//        endColor,
//        Shader.TileMode.CLAMP
//    )
//    this.paint.shader = shader
//}
fun Context.toast(text:String){
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}


