package lambda.aaron.countries.controllers;

import lambda.aaron.countries.models.Country;
import java.util.List;


public interface HelperFunctions {

    List<Country> findCountries (List<Country> countryList, FilterCountries filter);
}
