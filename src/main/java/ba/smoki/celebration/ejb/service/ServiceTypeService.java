package ba.smoki.celebration.ejb.service;

import ba.smoki.celebration.ejb.AbstractService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ServiceTypeService  extends AbstractService<ServiceType> implements ServiceTypeServiceLocal {

    @PersistenceContext(unitName = "celebrationPU")
    private EntityManager entityManager;

    public ServiceTypeService() {
        super(ServiceType.class);
    }

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }
}
