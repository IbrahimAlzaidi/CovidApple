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
     * this function take one parameter and return TotalPeopleVaccinatedForCountry
     * @param country
     */
     fun getTotalPeopleVaccinatedForCountry(country: String?) =
        vaccineList.filter {
            it.country?.equals(country, ignoreCase = true) == true
        }.maxOf { it.peopleFullyVaccinated ?: 0 }

    private fun getTotalPeopleVaccinatedForCountryTemp(country: String?) =
        vaccineList.filter {
            it.country?.equals(country, ignoreCase = true) == true
        }.maxOf { it.peopleFullyVaccinated ?: 0 }

    /**
     * this function take no parameter and return TotalVaccinatedPeopleForAllCountries
     */
    fun getTotalVaccinatedForAllCountry()=vaccineList.groupBy {
        it.country}.keys.associateWith { getTotalPeopleVaccinatedForCountry(it) }.toList()

    fun getTotalVaccinatedForAllCountryTemp()=vaccineList.groupBy {
        it.country}.keys.associateWith { getTotalPeopleVaccinatedForCountryTemp(it) }.toList()
    /**
     * this function take no parameter and return TotalVaccinationForAllCountries
     * take the top 5.
     */

    fun getTotalVaccinatedForAllCountries() = vaccineList.groupBy {
        it.country
    }.keys.associateWith { getTotalPeopleVaccinatedForCountry(it) }.toList().sortedBy {
            (_,v) ->
        v.times(-1)
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


}