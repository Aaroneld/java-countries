package lambda.aaron.countries.controllers;

import lambda.aaron.countries.models.Country;
import lambda.aaron.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepo;

    @Autowired
    HelperFunctions helperFunctions;

    @GetMapping(value = "/countries/all",
            produces = {"application/json"})
    public ResponseEntity<?> listAllCountries()
    {
        List<Country> myCountries = new ArrayList<Country>();
        countryRepo.findAll().iterator().forEachRemaining(myCountries::add);

        return new ResponseEntity<>(myCountries, HttpStatus.OK);
    }

    @GetMapping( value = "/countries/start/{letter}",
    produces = {"application/json"})
    public ResponseEntity<?> listAllByCharacter(@PathVariable char letter)
    {
        List<Country> myCountries = new ArrayList<Country>();
        countryRepo.findAll().iterator().forEachRemaining(myCountries::add);

        List<Country> filteredList = helperFunctions.findCountries(myCountries, c -> Character.toLowerCase(c.getName().charAt(0)) == Character.toLowerCase(letter));

        return new ResponseEntity<>(filteredList, HttpStatus.OK);
    }

    @GetMapping( value = "/countries/population",
                produces = {"application/json"})
    public ResponseEntity<?> getPopulationTotal()
    {
        List<Country> myCountries = new ArrayList<Country>();
        countryRepo.findAll().iterator().forEachRemaining(myCountries::add);

        long popTotal = 0;

        for(Country c: myCountries)
        {
            popTotal += c.getPopulation();
        }

        return new ResponseEntity<>(popTotal, HttpStatus.OK);
    }

    @GetMapping( value = "/countries/population/min",
    produces = {"application/json"})
    public ResponseEntity<?> getMinPopCountry()
    {
        List<Country> myCountries = new ArrayList<Country>();
        countryRepo.findAll().iterator().forEachRemaining(myCountries::add);

        long maxCompare = (long) Double.POSITIVE_INFINITY;
        Country minCountry = new Country();

        for(Country c: myCountries)
        {
            if(c.getPopulation() < maxCompare)
            {
                maxCompare = c.getPopulation();
                minCountry = c;
            }
        }

        return new ResponseEntity<>(minCountry, HttpStatus.OK);
    }

    @GetMapping( value = "/countries/population/max",
            produces = {"application/json"})
    public ResponseEntity<?> getMaxPopCountry()
    {
        List<Country> myCountries = new ArrayList<Country>();
        countryRepo.findAll().iterator().forEachRemaining(myCountries::add);

        long maxCompare = (long) Double.NEGATIVE_INFINITY;
        Country maxCountry = new Country();

        for(Country c: myCountries)
        {
            if(c.getPopulation() > maxCompare)
            {
                maxCompare = c.getPopulation();
                maxCountry = c;
            }
        }

        return new ResponseEntity<>(maxCountry, HttpStatus.OK);
    }

    @GetMapping( value = "/countries/population/median",
            produces = {"application/json"})
    public ResponseEntity<?> getMedianPopCountry()
    {
        List<Country> myCountries = new ArrayList<Country>();
        countryRepo.findAll().iterator().forEachRemaining(myCountries::add);

        myCountries.sort((c1, c2) -> (int) c1.getPopulation() - (int) c2.getPopulation());

        Country medianCountry = new Country();

        if(myCountries.size() % 2 == 0)
        {
            medianCountry = myCountries.get(myCountries.size() / 2 -1);
        }
        else
        {
            medianCountry = myCountries.get((myCountries.size() +1 ) /2);
        }

        return new ResponseEntity<>(medianCountry, HttpStatus.OK);
    }



}
