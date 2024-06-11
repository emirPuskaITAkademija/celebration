package ba.smoki.celebration.rest.town;

import ba.smoki.celebration.ejb.town.Town;
import ba.smoki.celebration.ejb.town.TownServiceLocal;
import jakarta.activation.MimeType;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path(("/towns"))
public class TownRestService {

    @Inject
    private TownServiceLocal townServiceLocal;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Town> findAll(){
        return townServiceLocal.findAll();
    }
}
