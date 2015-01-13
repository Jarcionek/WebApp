package webapp;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class PostResource {

    public static final String HEADER_NAME = "data";

    @POST
    @Path("/post")
    @Produces(MediaType.TEXT_PLAIN)
    @Timed
    public String blah(@DefaultValue("this is a default value for header name \"" + HEADER_NAME + "\"") @HeaderParam(HEADER_NAME) String data) {
        return "you have posted: \n" + data;
    }

}
