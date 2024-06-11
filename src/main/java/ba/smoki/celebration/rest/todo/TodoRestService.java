package ba.smoki.celebration.rest.todo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

//base_url/api/todos
@Path(("/todos"))
public class TodoRestService {

    public static final List<String> TODO_LIST = List.of(
            "Oprati suđe", "Pročitati predavanje iz Jave",
            "JavaScript naučiti", "Android App deve naučiti",
            "Naučiti Kineski"
    );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> todos() {
        return TODO_LIST;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPrivilege(@PathParam("id") int id) {
        if (id > (TODO_LIST.size() - 1)) {
            throw new RuntimeException("Not exist element with id " + id);
        }
        return TODO_LIST.get(id);
    }
}
