package com.example.entity.viewState

sealed class ViewState<out T> {
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(val code: Int, val message: String) : ViewState<Nothing>()
}
