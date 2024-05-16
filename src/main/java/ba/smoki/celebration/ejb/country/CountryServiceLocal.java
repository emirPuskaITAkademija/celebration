package ba.smoki.celebration.ejb.country;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CountryServiceLocal {
    void create(Country country);

    void edit(Country country);

    void delete(Country country);

    Country find(Object id);

    List<Country> findAll();
}
