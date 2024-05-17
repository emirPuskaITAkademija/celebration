package ba.smoki.celebration.ejb.user.privilege;

import ba.smoki.celebration.ejb.AbstractService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PrivilegeService extends AbstractService<Privilege> implements PrivilegeServiceLocal {

    @PersistenceContext(unitName = "celebrationPU")
    private EntityManager entityManager;

    public PrivilegeService() {
        super(Privilege.class);
    }

    @Override
    protected EntityManager entityManager() {
        return entityManager;
    }
}
