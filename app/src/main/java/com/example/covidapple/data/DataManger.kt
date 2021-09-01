package com.example.covidapple.data

import android.annotation.SuppressLint
import com.example.covidapple.data.domain.Vaccine
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.absoluteValue
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

    fun getTotalDailyVaccinationForCountry(country: String?) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.sumOf { it.dailyVaccinations ?: 0 }


    /**
     * this function take one parameter and return TotalPeopleVaccinatedForCountry
     * @param country
     */
    private fun getTotalPeopleVaccinatedForCountry(country: String?) =
        vaccineList.filter {
            it.country?.equals(country, ignoreCase = true) == true
        }.maxOf { it.peopleFullyVaccinated ?: 0 }

    /**
     * this function take one parameter and return getTotalVaccinatedForAllCountry
     */

    fun getTotalVaccinatedForAllCountry()=vaccineList.groupBy {
        it.country}.keys.associateWith { getTotalPeopleVaccinatedForCountry(it) }.toList().sortedByDescending { (_,v) -> v }
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
    }.toList().sortedBy { (k,_) -> k }.toMap()



    /**
     * this function take one parameter and return TotalVaccinationForCountry
     * @param country
     */

    private fun getTotalVaccinationForCountry(country: String?) =
        vaccineList.filter {
            it.country?.equals(country, ignoreCase = true) == true
        }.maxOf { it.totalVaccinations ?: 0 }

    /**
     * this function take one parameter and return TotalVaccinationForAllCountries
     */
    fun getTotalVaccinationForAllCountries() : Long = vaccineList.groupBy {
        it.country}.keys.associateWith { getTotalVaccinationForCountry(it) }.toList().sumByDouble { it.second.toDouble() }.toLong()

    /**
     * this function take one parameter and return TotalPeopleVaccinatedOneTimeForCountry
     * @param country
     */
    private fun getTotalPeopleVaccinatedOneTimeForCountry(country: String?) =
        vaccineList.filter {
            it.country?.equals(country, ignoreCase = true) == true
        }.maxOf { it.peopleVaccinated ?: 0 }

    /**
     * this function take one parameter and return TotalPeopleVaccinatedOneTimeForAll
     */
    fun getTotalPeopleVaccinatedOneTimeForAll() : Long = vaccineList.groupBy {
        it.country}.keys.associateWith { getTotalPeopleVaccinatedOneTimeForCountry(it) }.toList().sumByDouble { it.second.toDouble() }.toLong()

    /**
     * this function take one parameter and return TotalDailyVaccinationsForCountry
     * @param country
     */

    private fun getTotalDailyVaccinationsForCountry(country: String?) =
        vaccineList.filter {
            it.country?.equals(country, ignoreCase = true) == true
        }.sumOf { it.dailyVaccinations ?: 0 }

    /**
     * this function take one parameter and return TotalDailyVaccinations
     */
    fun getTotalDailyVaccinations() = vaccineList.groupBy {
        it.country}.keys.associateWith { getTotalDailyVaccinationsForCountry(it) }.toList().sumByDouble { it.second.toDouble() }.toLong()
}