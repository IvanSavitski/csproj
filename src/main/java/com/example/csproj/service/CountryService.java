package com.example.csproj.service;


import com.example.csproj.models.Country;
import com.example.csproj.models.Country_;
import com.example.csproj.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Cacheable(value = "country", key = "#root.method.name")
    public List<Country> getCountriesWithEnglish() {
        return countryRepository.findCountriesWithEnglish();
    }

    @Cacheable(value = "country", key = "#root.method.name")
    public List<Country> getCountriesWithMoreThenThreeLanguages() {
        return countryRepository.findCountriesWithMoreThenThreeLanguages();
    }

    @Cacheable(value = "country", key = "#root.method.name")
    public List<Country> getCountriesWithFrancheEnglish() {
        return countryRepository.findCountriesWithFrancheEnglish();
    }

    @Cacheable(value = "country", key = "#root.method.name")
    public List<Country> getCountriesWithMoreThenTenMillionPopulation() {
        return countryRepository.findCountriesWithMoreThenTenMillionPopulation();
    }

    @Cacheable(value = "country", key = "#root.method.name")
    public List<Country> getCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation() {
        return countryRepository.findCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation();
    }

    @Cacheable(value = "country", key = "#root.method.name")
    public List<Country> getCountriesWithoutEnglish() {
        return countryRepository.findCountriesWithoutEnglish();
    }

    @Cacheable(value = "country", key = "#root.method.name")
    public List<Country_> getCountriesWithBiggestLanguagesCount() {
        return countryRepository.findCountriesWithBiggestLanguagesCount();
    }
}