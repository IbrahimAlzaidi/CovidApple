package com.example.covidapple.util

import android.annotation.SuppressLint
import android.graphics.Color
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.ln
import kotlin.math.pow
import kotlin.random.Random

object Helper {

    /**
     * this function will make the number as an abbreviated string
     * @param Long number representing the data
     * @return abbreviated string of the string
     */

    @SuppressLint("DefaultLocale")
    fun abbreviateTheNumber(number:Long):String {
        if (number < 1000) return "" + number
        val exp = (ln(number.toDouble()) / ln(1000.0)).toInt()
        return java.lang.String.format(
            "%.1f %c", //format the appearance of the number
            number / 1000.0.pow(exp.toDouble()),
            "kMB"[exp - 1]
        )
    }

    /**
     * Function to get the Color.
     */
    fun colorSet() = Color.argb(
        255, Random.nextInt(50, 200),
        Random.nextInt(50, 250), Random.nextInt(50, 250)
    )

    fun getListOfCountries() : ArrayList<String> {
        val isoCountryCodes = Locale.getISOCountries()
        val countryListWithEmojis = ArrayList<String>()
        for (countryCode in isoCountryCodes) {
            val locale = Locale("", countryCode)
            val countryName = locale.displayCountry
            val firstChar = Character.codePointAt(countryCode, 0) - 0x41 + 0x1F1E6
            val secondChar = Character.codePointAt(countryCode, 1) - 0x41 + 0x1F1E6
            val flag =
                (String(Character.toChars(firstChar)) + String(Character.toChars(secondChar)))
            countryListWithEmojis.add("$flag  $countryName")
        }
        return countryListWithEmojis

    }

}