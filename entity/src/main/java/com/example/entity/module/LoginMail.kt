package com.example.entity.module

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginMail(val mailOrPhone: String,val password: String,) : Parcelable {
    companion object {
        fun emptyUserLogin(): LoginMail =
            LoginMail("","")
    }
}
