package webapp;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("")
public class PathParamResource {

    @GET
    @Path("/random/{min}/{max}")
    @Produces(MediaType.TEXT_PLAIN)
    @Timed
    public int returnRandomInteger(@PathParam("min") int min, @PathParam("max") int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }

}
