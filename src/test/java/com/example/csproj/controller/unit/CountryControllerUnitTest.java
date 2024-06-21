package com.example.csproj.controller.unit;


import com.example.csproj.models.Country;
import com.example.csproj.repository.CountryRepository;
import com.example.csproj.service.CountryService;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class CountryControllerUnitTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    @Test
    public void testGetCountriesWithEnglish() {
        List<Country> mockCountries = Arrays.asList(
                new Country("Canada", "English, French", Arrays.asList("English", "French"), 2L, false, true, 37058856L, 935000L, 36123856L),
                new Country("Ireland", "English, Irish", Arrays.asList("English', 'Irish"), 2L, false, true, 4937786L, 554554L, 4383232L),
                new Country("United Kingdom", "English", Arrays.asList("English"), 1L, false, true, 66436569L, 8982000L, 57454569L)
        );

        when(countryRepository.findCountriesWithEnglish()).thenReturn(mockCountries);

        List<Country> result = countryService.getCountriesWithEnglish();

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("Canada", result.get(0).getCountryName());
        Assertions.assertEquals("Ireland", result.get(1).getCountryName());
        Assertions.assertEquals("United Kingdom", result.get(2).getCountryName());
    }

    @Test
    public void testGetCountriesWithMoreThenThreeLanguages() {
        List<Country> mockCountries = Arrays.asList(
                new Country("Austria", "German, Burgenland Croatian, Hungarian, Slovene", Arrays.asList("German", "Burgenland Croatian", "Hungarian", "Slovene"), 4L, true, false, 8917508L, 1888776L, 7028732L),
                new Country("Denmark", "Danish, Faroese, Greenlandic", Arrays.asList("Danish", "Faroese", "Greenlandic"), 3L, true, false, 5806081L, 602481L, 5203600L),
                new Country("Belgium", "Dutch, French, German", Arrays.asList("Dutch", "French", "German"), 3L, false, false, 11589623L, 1219970L, 10369653L),
                new Country("Switzerland", "German, French, Italian", Arrays.asList("German", "French", "Italian"), 3L, false, false, 8654622L, 418132L, 8236490L)
        );

        when(countryRepository.findCountriesWithMoreThenThreeLanguages()).thenReturn(mockCountries);

        List<Country> result = countryService.getCountriesWithMoreThenThreeLanguages();

        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals("Austria", result.get(0).getCountryName());
        Assertions.assertEquals("Denmark", result.get(1).getCountryName());
        Assertions.assertEquals("Belgium", result.get(2).getCountryName());
        Assertions.assertEquals("Switzerland", result.get(3).getCountryName());
    }

    @Test
    public void testGetCountriesWithFrancheEnglish() {
        List<Country> mockCountries = Arrays.asList(
                new Country("Canada", "English, French", Arrays.asList("English", "French"), 2L, false, true, 37058856L, 935000L, 36123856L)
        );

        when(countryRepository.findCountriesWithFrancheEnglish()).thenReturn(mockCountries);

        List<Country> result = countryService.getCountriesWithFrancheEnglish();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Canada", result.get(0).getCountryName());
    }

    @Test
    public void testGetCountriesWithMoreThenTenMillionPopulation() {
        List<Country> mockCountries = Arrays.asList(
                new Country("Spain", "Spanish", Arrays.asList("Spanish"), 1L, false, false, 46934632L, 3223334L, 43711298L),
                new Country("Romania", "Romanian", Arrays.asList("Romanian"), 1L, false, false, 19237691L, 1883425L, 17354266L),
                new Country("Portugal", "Portuguese", Arrays.asList("Portuguese"), 1L, true, false, 10196709L, 505526L, 9691183L),
                new Country("Canada", "English, French", Arrays.asList("English", "French"), 2L, false, true, 37058856L, 935000L, 36123856L),
                new Country("Belgium", "Dutch, French, German", Arrays.asList("Dutch", "French", "German"), 3L, false, false, 11589623L, 1219970L, 10369653L),
                new Country("Sweden", "Swedish, Finnish", Arrays.asList("Swedish", "Finnish"), 2L, true, false, 10099265L, 935619L, 9163646L),
                new Country("United Kingdom", "English", Arrays.asList("English"), 1L, false, true, 66436569L, 8982000L, 57454569L),
                new Country("Greece", "Greek", Arrays.asList("Greek"), 1L, true, false, 10716322L, 664046L, 10052276L),
                new Country("Russia", "Russian", Arrays.asList("Russian"), 1L, false, false, 144100000L, 12655050L, 131444950L),
                new Country("France", "French", Arrays.asList("French"), 1L, false, false, 67059887L, 2206488L, 64853399L),
                new Country("Netherlands", "Dutch", Arrays.asList("Dutch"), 1L, false, false, 17231017L, 872680L, 16358337L),
                new Country("Germany", "German", Arrays.asList("German"), 1L, false, false, 83123456L, 3670000L, 79453456L),
                new Country("Poland", "Polish", Arrays.asList("Polish"), 1L, false, false, 37846611L, 1765069L, 36081542L),
                new Country("Italy", "Italian", Arrays.asList("Italian"), 1L, false, false, 60359546L, 2873494L, 57486052L)
        );

        when(countryRepository.findCountriesWithMoreThenTenMillionPopulation()).thenReturn(mockCountries);

        List<Country> result = countryService.getCountriesWithMoreThenTenMillionPopulation();

        Assertions.assertEquals(14, result.size());
        Assertions.assertEquals("Spain", result.get(0).getCountryName());
        Assertions.assertEquals("Romania", result.get(1).getCountryName());
        Assertions.assertEquals("Portugal", result.get(2).getCountryName());
        Assertions.assertEquals("Canada", result.get(3).getCountryName());
        Assertions.assertEquals("Belgium", result.get(4).getCountryName());
        Assertions.assertEquals("Sweden", result.get(5).getCountryName());
        Assertions.assertEquals("United Kingdom", result.get(6).getCountryName());
        Assertions.assertEquals("Greece", result.get(7).getCountryName());
        Assertions.assertEquals("Russia", result.get(8).getCountryName());
        Assertions.assertEquals("France", result.get(9).getCountryName());
        Assertions.assertEquals("Netherlands", result.get(10).getCountryName());
        Assertions.assertEquals("Germany", result.get(11).getCountryName());
        Assertions.assertEquals("Poland", result.get(12).getCountryName());
        Assertions.assertEquals("Italy", result.get(13).getCountryName());
    }

    @Test
    public void testGetCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation() {
        List<Country> mockCountries = Arrays.asList(
                new Country("Austria", "German, Burgenland Croatian, Hungarian, Slovene", Arrays.asList("German", "Burgenland Croatian", "Hungarian", "Slovene"), 4L, true, false, 8917508L, 1888776L, 7028732L),
                new Country("Denmark", "Danish, Faroese, Greenlandic", Arrays.asList("Danish", "Faroese", "Greenlandic"), 3L, true, false, 5806081L, 602481L, 5203600L),
                new Country("Portugal", "Portuguese", Arrays.asList("Portuguese"), 1L, true, false, 10196709L, 505526L, 9691183L),
                new Country("Sweden", "Swedish, Finnish", Arrays.asList("Swedish", "Finnish"), 2L, true, false, 10099265L, 935619L, 9163646L),
                new Country("Norway", "Norwegian, Sami", Arrays.asList("Norwegian", "Sami"), 2L, true, false, 5421241L, 694694L, 4726547L),
                new Country("Greece", "Greek", Arrays.asList("Greek"), 1L, true, false, 10716322L, 664046L, 10052276L)
        );

        when(countryRepository.findCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation()).thenReturn(mockCountries);

        List<Country> result = countryService.getCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation();

        Assertions.assertEquals(6, result.size());
        Assertions.assertEquals("Austria", result.get(0).getCountryName());
        Assertions.assertEquals("Denmark", result.get(1).getCountryName());
        Assertions.assertEquals("Portugal", result.get(2).getCountryName());
        Assertions.assertEquals("Sweden", result.get(3).getCountryName());
        Assertions.assertEquals("Norway", result.get(4).getCountryName());
        Assertions.assertEquals("Greece", result.get(5).getCountryName());
    }

    @Test
    public void testGetCountriesWithoutEnglish() {
        List<Country> mockCountries = Arrays.asList(
                new Country("Spain", "Spanish", Arrays.asList("Spanish"), 1L, false, false, 46934632L, 3223334L, 43711298L),
                new Country("Austria", "German, Burgenland Croatian, Hungarian, Slovene", Arrays.asList("German", "Burgenland Croatian", "Hungarian", "Slovene"), 4L, true, false, 8917508L, 1888776L, 7028732L),
                new Country("Denmark", "Danish, Faroese, Greenlandic", Arrays.asList("Danish", "Faroese", "Greenlandic"), 3L, true, false, 5806081L, 602481L, 5203600L),
                new Country("Romania", "Romanian", Arrays.asList("Romanian"), 1L, false, false, 19237691L, 1883425L, 17354266L),
                new Country("Portugal", "Portuguese", Arrays.asList("Portuguese"), 1L, true, false, 10196709L, 505526L, 9691183L),
                new Country("Belgium", "Dutch, French, German", Arrays.asList("Dutch", "French", "German"), 3L, false, false, 11589623L, 1219970L, 10369653L),
                new Country("Sweden", "Swedish, Finnish", Arrays.asList("Swedish", "Finnish"), 2L, true, false, 10099265L, 935619L, 9163646L),
                new Country("Norway", "Norwegian, Sami", Arrays.asList("Norwegian", "Sami"), 2L, true, false, 5421241L, 694694L, 4726547L),
                new Country("Greece", "Greek", Arrays.asList("Greek"), 1L, true, false, 10716322L, 664046L, 10052276L),
                new Country("Russia", "Russian", Arrays.asList("Russian"), 1L, false, false, 144100000L, 12655050L, 131444950L),
                new Country("Switzerland", "German, French, Italian", Arrays.asList("German", "French", "Italian"), 3L, false, false, 8654622L, 418132L, 8236490L),
                new Country("France", "French", Arrays.asList("French"), 1L, false, false, 67059887L, 2206488L, 64853399L),
                new Country("Finland", "Finnish, Swedish", Arrays.asList("Finnish", "Swedish"), 2L, false, false, 5540720L, 643272L, 4897448L),
                new Country("Netherlands", "Dutch", Arrays.asList("Dutch"), 1L, false, false, 17231017L, 872680L, 16358337L),
                new Country("Germany", "German", Arrays.asList("German"), 1L, false, false, 83123456L, 3670000L, 79453456L),
                new Country("Poland", "Polish", Arrays.asList("Polish"), 1L, false, false, 37846611L, 1765069L, 36081542L),
                new Country("Italy", "Italian", Arrays.asList("Italian"), 1L, false, false, 60359546L, 2873494L, 57486052L)
        );

        when(countryRepository.findCountriesWithoutEnglish()).thenReturn(mockCountries);

        List<Country> result = countryService.getCountriesWithoutEnglish();

        Assertions.assertEquals(17, result.size());
        Assertions.assertEquals("Spain", result.get(0).getCountryName());
        Assertions.assertEquals("Austria", result.get(1).getCountryName());
        Assertions.assertEquals("Denmark", result.get(2).getCountryName());
        Assertions.assertEquals("Romania", result.get(3).getCountryName());
        Assertions.assertEquals("Portugal", result.get(4).getCountryName());
        Assertions.assertEquals("Belgium", result.get(5).getCountryName());
        Assertions.assertEquals("Sweden", result.get(6).getCountryName());
        Assertions.assertEquals("Norway", result.get(7).getCountryName());
        Assertions.assertEquals("Greece", result.get(8).getCountryName());
        Assertions.assertEquals("Russia", result.get(9).getCountryName());
        Assertions.assertEquals("Switzerland", result.get(10).getCountryName());
        Assertions.assertEquals("France", result.get(11).getCountryName());
        Assertions.assertEquals("Finland", result.get(12).getCountryName());
        Assertions.assertEquals("Netherlands", result.get(13).getCountryName());
        Assertions.assertEquals("Germany", result.get(14).getCountryName());
        Assertions.assertEquals("Poland", result.get(15).getCountryName());
        Assertions.assertEquals("Italy", result.get(16).getCountryName());
    }
}

/**/