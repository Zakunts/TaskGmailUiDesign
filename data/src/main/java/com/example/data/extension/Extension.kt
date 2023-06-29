package com.example.data.extension

import android.content.Context
import android.widget.Toast
import com.google.gson.Gson

fun <T> T.convertGenericToString(): String = Gson().toJson(this)

inline fun <reified T> String.convertStringToGeneric(): T = Gson().fromJson(this, T::class.java)


fun Context.toast(text:String){
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}