package ba.smoki.celebration.ejb.town;

import ba.smoki.celebration.ejb.service.ServiceType;
import jakarta.ejb.Local;

import java.util.List;


@Local
public interface TownServiceLocal {

    void create(Town town);

    void edit(Town town);

    void delete(Town town);

    Town find(Object id);

    List<Town> findAll();
}
