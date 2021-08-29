package com.example.covidapple.util

import android.util.Log

fun <T> T?.log(tag: String = "GREEN_APPLE"): T? {
    Log.i(tag, this.toString())
    return this
}

fun<T> isEqual(first: List<T>, second: List<T>): Boolean {

    if (first.size != second.size) {
        return false
    }

    return first.zip(second).all { (x, y) -> x == y }
}