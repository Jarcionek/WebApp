package webapp;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("")
public class QueryParamResource {

    @GET
    @Path("/random")
    @Produces(MediaType.TEXT_PLAIN)
    @Timed
    public int returnRandomInteger(@QueryParam("min") int min, @QueryParam("max") int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }

}
