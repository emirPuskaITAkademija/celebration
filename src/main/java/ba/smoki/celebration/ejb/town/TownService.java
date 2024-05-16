package ba.smoki.celebration.ejb.town;

import ba.smoki.celebration.ejb.AbstractService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
class TownService extends AbstractService<Town> implements TownServiceLocal {

    @PersistenceContext(unitName = "celebrationPU")
    private EntityManager entityManager;

    public TownService() {
        super(Town.class);
    }

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }
}
