package com.example.covidapple.util

import android.util.Log
import com.example.covidapple.data.domain.Vaccine
import java.util.*
import kotlin.collections.ArrayList

fun <T> T?.log(tag: String = "GREEN_APPLE"): T? {
    Log.i(tag, this.toString())
    return this
}

fun<T> List<T>.isEqual(first: List<T>): Boolean {

    if (this.size != first.size) {
        return false
    }

    return this.zip(first).all { (x, y) -> x == y }
}

fun String.mapName(): String? {
    val isoCountryCodes = Locale.getISOCountries()
    val countryListWithEmojis = ArrayList<String>()
    for (countryCode in isoCountryCodes) {
        val locale = Locale("", countryCode)
        val countryName = locale.displayCountry
        val firstChar = Character.codePointAt(countryCode, 0) - 0x41 + 0x1F1E6
        val secondChar = Character.codePointAt(countryCode, 1) - 0x41 + 0x1F1E6
        val flag =
            (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
        countryListWithEmojis.add("$countryName $flag")
    }



    return countryListWithEmojis.find { it.startsWith(this)}

}