package com.example.covidapple.data

import android.annotation.SuppressLint
import com.example.covidapple.data.domain.Vaccine
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.ln
import kotlin.math.pow

object DataManger {

    private val vaccineList = mutableListOf<Vaccine>()
    val filteredList:List<Vaccine>
        get()= vaccineList

    /**
     * This function fill the list of Vaccine
     */
    fun addVaccine(vaccine: Vaccine) = vaccineList.add(vaccine)

    /**
     * this function take one parameter and return TotalDailyVaccinationForCountry
     * @param country
     */

    /**
     *  Should change the description of the function into " This function take one parameter and
     *  return the summation of vaccine unit of the country
     *
    */

    fun getTotalDailyVaccinationForCountry(country: String?) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.sumOf { it.dailyVaccinations ?: 0 }


    /**
     * this function take one parameter and return TotalVaccinatedForCountry
     * @param country
     */
    fun getTotalVaccinatedForCountry(country: String?):Int? =
        vaccineList.findLast { it.country.equals(country,ignoreCase = true) }?.peopleFullyVaccinated

    private fun getTotalPeopleVaccinatedForCountry(country: String?) =
        vaccineList.filter {
            it.country?.equals(country, ignoreCase = true) == true
        }.maxOf { it.peopleFullyVaccinated ?: 0 }


    fun getTotalVaccinatedForAllCountry()=vaccineList.groupBy {
        it.country}.keys.associateWith { getTotalPeopleVaccinatedForCountry(it) }.toList()
    //region

//   fun getTotalVaccinatedForCountry(country: String?) = vaccineList.filter {
//        it.country?.equals(country, ignoreCase = true) == true
//    }.sumOf { it.peopleFullyVaccinated ?: 0}
    //endregion


    /**
     * this function take no parameter and return TotalVaccinationForAllCountries
     * take the top 5.
     */
    fun getTotalVaccinationForAllCountries() = vaccineList.groupBy {
        it.country
    }.keys.associateWith { getTotalVaccinatedForCountry(it) }.toList()


    /**
     * this function take no parameter and return TotalVaccinatedForAllCountries
     */
    fun getTotalVaccinatedForAllCountries() = vaccineList.groupBy {
        it.country
    }.keys.associateWith { getTotalVaccinatedForCountry(it) }.toList().sortedBy {
            (_,v) ->
        v?.times(-1)
    }.take(5).toMap()

    /**
     * this function take one parameter and return VaccinationMapOfCountry
     * @param country
     */

    fun getVaccinationMapOfCountry(country: String) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.associate {
        Pair(it.date, it.dailyVaccinations)
    }.toList().sortedBy { (_,v) -> v }.toMap()


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