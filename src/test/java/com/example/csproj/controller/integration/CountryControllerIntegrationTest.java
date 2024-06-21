package com.example.csproj.controller.integration;


import com.example.csproj.controller.CountryController;
import com.example.csproj.models.Country;
import com.example.csproj.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


@WebMvcTest(CountryController.class)
public class CountryControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    public void testGetCountriesWithEnglish() throws Exception {
        List<Country> mockCountries = Arrays.asList(
                new Country("Canada", "English, French", Arrays.asList("English", "French"), 2L, false, true, 37058856L, 935000L, 36123856L),
                new Country("Ireland", "English, Irish", Arrays.asList("English', 'Irish"), 2L, false, true, 4937786L, 554554L, 4383232L),
                new Country("United Kingdom", "English", Arrays.asList("English"), 1L, false, true, 66436569L, 8982000L, 57454569L)
        );

        when(countryService.getCountriesWithEnglish()).thenReturn(mockCountries);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/english")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countryName", is("Canada")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].countryName", is("Ireland")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].countryName", is("United Kingdom")));
    }

    @Test
    public void testGetCountriesWithMoreThenThreeLanguages() throws Exception {
        List<Country> mockCountries = Arrays.asList(
                new Country("Austria", "German, Burgenland Croatian, Hungarian, Slovene", Arrays.asList("German", "Burgenland Croatian", "Hungarian", "Slovene"), 4L, true, false, 8917508L, 1888776L, 7028732L),
                new Country("Denmark", "Danish, Faroese, Greenlandic", Arrays.asList("Danish", "Faroese", "Greenlandic"), 3L, true, false, 5806081L, 602481L, 5203600L),
                new Country("Belgium", "Dutch, French, German", Arrays.asList("Dutch", "French", "German"), 3L, false, false, 11589623L, 1219970L, 10369653L),
                new Country("Switzerland", "German, French, Italian", Arrays.asList("German", "French", "Italian"), 3L, false, false, 8654622L, 418132L, 8236490L)
        );

        when(countryService.getCountriesWithMoreThenThreeLanguages()).thenReturn(mockCountries);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/more_3_languages")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countryName", is("Austria")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].countryName", is("Denmark")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].countryName", is("Belgium")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].countryName", is("Switzerland")));
    }

    @Test
    public void testGetCountriesWithFrancheEnglish() throws Exception {
        List<Country> mockCountries = Arrays.asList(
                new Country("Canada", "English, French", Arrays.asList("English", "French"), 2L, false, true,37058856L, 935000L, 36123856L)
        );

        when(countryService.getCountriesWithFrancheEnglish()).thenReturn(mockCountries);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/franche_english_languages")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countryName", is("Canada")));
    }

    @Test
    public void testGetCountriesWithMoreThenTenMillionPopulation() throws Exception {
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

        when(countryService.getCountriesWithMoreThenTenMillionPopulation()).thenReturn(mockCountries);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/more_10m_population")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(14)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countryName", is("Spain")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].countryName", is("Romania")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].countryName", is("Portugal")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].countryName", is("Canada")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4].countryName", is("Belgium")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[5].countryName", is("Sweden")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[6].countryName", is("United Kingdom")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[7].countryName", is("Greece")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[8].countryName", is("Russia")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[9].countryName", is("France")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[10].countryName", is("Netherlands")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[11].countryName", is("Germany")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[12].countryName", is("Poland")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[13].countryName", is("Italy")));
    }

    @Test
    public void testGetCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation() throws Exception {
        List<Country> mockCountries = Arrays.asList(
                new Country("Austria", "German, Burgenland Croatian, Hungarian, Slovene", Arrays.asList( "German", "Burgenland Croatian", "Hungarian", "Slovene"), 4L, true, false, 8917508L, 1888776L, 7028732L),
                new Country("Denmark", "Danish, Faroese, Greenlandic", Arrays.asList("Danish", "Faroese", "Greenlandic"), 3L, true, false, 5806081L, 602481L, 5203600L),
                new Country("Portugal", "Portuguese", Arrays.asList("Portuguese"), 1L, true, false, 10196709L, 505526L, 9691183L),
                new Country("Sweden", "Swedish, Finnish", Arrays.asList("Swedish", "Finnish"), 2L, true, false, 10099265L, 935619L, 9163646L),
                new Country("Norway", "Norwegian, Sami", Arrays.asList("Norwegian", "Sami"), 2L, true, false, 5421241L, 694694L, 4726547L),
                new Country("Greece", "Greek", Arrays.asList("Greek"), 1L, true, false, 10716322L, 664046L, 10052276L)
                );

        when(countryService.getCountriesWhere_CapitalCitizensPopulation_isMoreThan_OthersCitiesPopulation()).thenReturn(mockCountries);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/capital_population")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(6)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countryName", is("Austria")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].countryName", is("Denmark")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].countryName", is("Portugal")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].countryName", is("Sweden")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4].countryName", is("Norway")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[5].countryName", is("Greece")));
    }

    @Test
    public void testGetCountriesWithoutEnglish() throws Exception {
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

        when(countryService.getCountriesWithoutEnglish()).thenReturn(mockCountries);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/countries/no_english")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(17)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countryName", is("Spain")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].countryName", is("Austria")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].countryName", is("Denmark")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].countryName", is("Romania")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4].countryName", is("Portugal")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[5].countryName", is("Belgium")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[6].countryName", is("Sweden")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[7].countryName", is("Norway")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[8].countryName", is("Greece")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[9].countryName", is("Russia")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[10].countryName", is("Switzerland")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[11].countryName", is("France")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[12].countryName", is("Finland")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[13].countryName", is("Netherlands")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[14].countryName", is("Germany")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[15].countryName", is("Poland")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[16].countryName", is("Italy")));
    }
}
