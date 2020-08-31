package lambda.aaron.countries.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long countryid;

    String name;
    long population;
    long landmasskm2;
    int medianage;

    public Country(String name, long population, long landmasskm2, int medianage)
    {
        this.name = name;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public Country()
    {
    }

    public long getCountryId() {
        return countryid;
    }

    public void setCountryId(long countryId) {
        this.countryid = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLandmasskm2() {
        return landmasskm2;
    }

    public void setLandmasskm2(long landmasskm2) {
        this.landmasskm2 = landmasskm2;
    }

    public int getMedianage() {
        return medianage;
    }

    public void setMedianage(int medianage) {
        this.medianage = medianage;
    }

    @Override
    public String toString() {
        return "Id= " + countryid + ",\n" +
                "Name: " + name + ",\n" +
                "Population: " + population + ",\n" +
                "LandMass in km2: " + landmasskm2 + ",\n" +
                "Median Age: " + medianage;

    }
}
