package lambda.aaron.countries.controllers;
import lambda.aaron.countries.models.Country;

public interface FilterCountries {

    boolean test(Country c);
}
