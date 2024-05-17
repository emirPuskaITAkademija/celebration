package ba.smoki.celebration.ejb.user.privilege;

import jakarta.ejb.Local;

import java.util.List;


@Local
public interface PrivilegeServiceLocal {

    void create(Privilege privilege);

    void edit(Privilege privilege);

    void delete(Privilege privilege);

    Privilege find(Object id);

    List<Privilege> findAll();
}
