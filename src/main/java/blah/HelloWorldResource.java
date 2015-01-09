package blah;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class HelloWorldResource {

    private final AtomicLong counter;

    public HelloWorldResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Path("/hello-world")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Map<String, Long> sayHello(@QueryParam("name") Optional<String> name) {
        return ImmutableMap.of("key", counter.incrementAndGet());
    }

}
