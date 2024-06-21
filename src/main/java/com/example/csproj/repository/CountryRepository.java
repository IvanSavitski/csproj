package com.example.csproj.repository;


import com.example.csproj.models.Country;
import com.example.csproj.models.Country_;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface CountryRepository extends CassandraRepository<Country, String> {
    //@Query("SELECT country_name FROM psql.countries WHERE country_languages LIKE 'English%'")
    //@Query("SELECT country_name FROM countries WHERE country_languages LIKE 'English'")
    //@Query("SELECT country_name FROM countries WHERE country_languages CONTAINS 'English'")
    //@Query("SELECT country_name FROM psql.countries WHERE country_languages REGEXP '\\bEnglish\\b'")
    //   @Query("SELECT country_name FROM countries WHERE split(country_languages, ',') CONTAINS 'English'")
    //@Query("SELECT country_name FROM countries WHERE ARRAY_CONTAINS(EXPLODE(country_languages), 'English')")
    @Query("SELECT * FROM psql3.countries WHERE country_languages LIKE 'English%';")
    List<Country> findCountriesWithEnglish();

    //@Query("SELECT country_name FROM countries WHERE length(country_languages) - length(replace(country_languages, ',', '')) >= 3")
    @Query("SELECT * FROM psql3.countries WHERE languages_count > 2 ALLOW FILTERING;")
    List<Country> findCountriesWithMoreThenThreeLanguages();

    //@Query("SELECT country_name FROM psql.countries WHERE country_languages LIKE 'English%' AND country_languages LIKE 'French%';")
    @Query("SELECT * FROM psql3.countries  WHERE country_languages_list CONTAINS 'English' AND country_languages_list CONTAINS 'French' ALLOW FILTERING;")
    List<Country> findCountriesWithFrancheEnglish();


    @Query("SELECT * FROM psql3.countries WHERE country_population > 10000000 ALLOW FILTERING;")
    List<Country> findCountriesWithMoreThenTenMillionPopulation();

    //@Query("SELECT * FROM psql.countries WHERE capital_population > non_capital_population ALLOW FILTERING;")
    @Query("SELECT * FROM psql3.countries WHERE is_capital_population_bigger = true ALLOW FILTERING;")
    List<Country> findCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation();
    //можно оптимизировать добавив тру фолс столбец


    //@Query("SELECT country_name FROM countries WHERE country_languages NOT LIKE '%English%'")
    @Query("SELECT * FROM psql3.countries WHERE is_english_language = false ALLOW FILTERING;")
    List<Country> findCountriesWithoutEnglish();


    //@Query("SELECT max(country_languages) from psql3.countries;")
    //@Query("SELECT country_name, max(country_languages), country_languages_list, languages_count, is_capital_population_bigger, is_english_language, country_population, capital_population, non_capital_population from psql3.countries;")
    @Query("SELECT max(languages_count) FROM psql3.countries;")
    List<Country_> findCountriesWithBiggestLanguagesCount();
}
