package com.example.covidapple.data

import com.example.covidapple.data.domain.Vaccine

object DataManger {

    private val vaccineList = mutableListOf<Vaccine>()
    fun addVaccine(vaccine: Vaccine) = vaccineList.add(vaccine)

    fun searchCountry( country : String) = vaccineList.filter { it.country?.contains(country)== true }
    fun searchCountryGroup( country : String) = vaccineList.groupBy { it.country }

}