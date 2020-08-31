package lambda.aaron.countries.repositories;

import lambda.aaron.countries.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long>
{
}
