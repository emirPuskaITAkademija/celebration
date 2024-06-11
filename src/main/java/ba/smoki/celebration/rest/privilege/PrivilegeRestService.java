package ba.smoki.celebration.rest.privilege;

import ba.smoki.celebration.ejb.town.Town;
import ba.smoki.celebration.ejb.town.TownServiceLocal;
import ba.smoki.celebration.ejb.user.privilege.Privilege;
import ba.smoki.celebration.ejb.user.privilege.PrivilegeServiceLocal;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path(("/privileges"))
public class PrivilegeRestService {

    @Inject
    private PrivilegeServiceLocal privilegeServiceLocal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Privilege> findAll() {
        return privilegeServiceLocal.findAll();
    }
}
