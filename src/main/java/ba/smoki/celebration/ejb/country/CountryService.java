package ba.smoki.celebration.ejb.country;

import ba.smoki.celebration.ejb.AbstractService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//CountryService countryService = new CountryService();
@Stateless
class CountryService extends AbstractService<Country> implements CountryServiceLocal {

    @PersistenceContext(unitName = "celebrationPU")
    private EntityManager entityManager;

    public CountryService() {
        super(Country.class);
    }

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }
}
