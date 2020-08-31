package lambda.aaron.countries.controllers;

import lambda.aaron.countries.models.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "helperFunctions")
public class HelperFunctionsImplementation implements HelperFunctions
{
    @Override
    public List<Country> findCountries(List<Country> countryList, FilterCountries filter) {
        List<Country> tempList = new ArrayList<>();

        for(Country c: countryList)
        {
            if(filter.test(c))
            {
                tempList.add(c);
            }
        }
        return tempList;
    }
}
