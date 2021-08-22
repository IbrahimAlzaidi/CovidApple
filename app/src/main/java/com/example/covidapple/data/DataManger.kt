package com.example.covidapple.data

import com.example.covidapple.data.domain.Vaccine

object DataManger {

    private val vaccineList = mutableListOf<Vaccine>()
    fun addVaccine(vaccine: Vaccine) = vaccineList.add(vaccine)


    fun getTotalVaccinationForCountry(country: String?) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.sumOf { it.dailyVaccinations ?: 0 }

    fun getTotalVaccinatedForCountry(country: String?) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.sumOf { it.peopleVaccinated ?: 0 }

    fun getTotalVaccinationForAllCountries() = vaccineList.groupBy {
        it.country
    }.keys.associateWith { getTotalVaccinationForCountry(it) }

    fun getTotalVaccinatedForAllCountries() = vaccineList.groupBy {
        it.country
    }.keys.associateWith { getTotalVaccinatedForCountry(it) }.toList().sortedBy { (_,v) -> v  }.take(10).toMap()

    fun getVaccinationMapOfCountry(country: String) = vaccineList.filter {
        it.country?.equals(country, ignoreCase = true) == true
    }.associate {
        Pair(it.date, it.dailyVaccinations)
    }.toList().sortedBy { (_,v) -> v }.toMap()


}