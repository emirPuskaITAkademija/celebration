package ba.smoki.celebration.ejb.service;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ServiceTypeServiceLocal {

    void create(ServiceType serviceType);

    void edit(ServiceType serviceType);

    void delete(ServiceType serviceType);

    ServiceType find(Object id);

    List<ServiceType> findAll();
}
