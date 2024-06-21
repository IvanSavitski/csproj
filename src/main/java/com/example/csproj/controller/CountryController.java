package com.example.csproj.controller;


import com.example.csproj.models.Country;
import com.example.csproj.models.Country_;
import com.example.csproj.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/countries/")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/english")
    public ResponseEntity<List<Country>> getCountriesWithEnglish() {
        List<Country> countries = countryService.getCountriesWithEnglish();
        return ResponseEntity.ok(countries);
    }


    @GetMapping("/more_3_languages")
    public ResponseEntity<List<Country>> getCountriesWithMoreThenThreeLanguages() {
        List<Country> countries = countryService.getCountriesWithMoreThenThreeLanguages();
        return ResponseEntity.ok(countries);
    }


    @GetMapping("/franche_english_languages")
    public ResponseEntity<List<Country>> getCountriesWithFrancheEnglish() {
        List<Country> countries = countryService.getCountriesWithFrancheEnglish();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/more_10m_population")
    public ResponseEntity<List<Country>> getCountriesWithMoreThenTenMillionPopulation() {
        List<Country> countries = countryService.getCountriesWithMoreThenTenMillionPopulation();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/capital_population")
    public ResponseEntity<List<Country>> getCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation() {
        List<Country> countries = countryService.getCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/no_english")
    public ResponseEntity<List<Country>> getCountriesWithoutEnglish() {
        List<Country> countries = countryService.getCountriesWithoutEnglish();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/biggest_langs_count")
    public ResponseEntity<List<Country_>> getCountriesWithBiggestLanguagesCount() {
        List<Country_> countries = countryService.getCountriesWithBiggestLanguagesCount();
        return ResponseEntity.ok(countries);
    }
}

