package webapp;

import com.codahale.metrics.annotation.Timed;
import webapp.numbers.StatisticsGenerator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("")
public class ListParamResource {

    private StatisticsGenerator statisticsGenerator = new StatisticsGenerator();

    @GET
    @Path("/stats")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Object returnRandomInteger(@QueryParam("n") List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return "error - empty list - example usage: /stats/?n=1&n=2&n=5";
        }

        return statisticsGenerator.generateStatistics(numbers);
    }

}
