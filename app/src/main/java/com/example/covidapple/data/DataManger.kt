package com.example.covidapple.data

import android.util.Log
import com.example.covidapple.data.domain.Vaccine

object DataManger {

    private val vaccineList = mutableListOf<Vaccine>()
    lateinit var filteredList:List<Vaccine>

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
    }.keys.associateWith { getTotalVaccinatedForCountry(it) }


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


}