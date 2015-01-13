package webapp;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Path("")
public class SimpleResource {

    private final AtomicLong counter = new AtomicLong();

    @GET
    @Path("/hello-world")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Map<String, Long> incrementAndGetHitCounter() {
        return ImmutableMap.of("hit-counter", counter.incrementAndGet());
    }

}
