package blah;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.LinkedHashMap;
import java.util.List;

@Path("")
public class ListParamResource {

    @GET
    @Path("/stats")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Object returnRandomInteger(@QueryParam("n") List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return "error - empty list - example usage: /stats/?n=1&n=2&n=5";
        }

        LinkedHashMap<String, Double> responseMap = new LinkedHashMap<>();

        responseMap.put("Root Mean Square", rms(numbers));
        responseMap.put("Arithmetic Mean", am(numbers));
        responseMap.put("Geometric Mean", gm(numbers));
        responseMap.put("Harmonic Mean", hm(numbers));

        return responseMap;
    }


    private Double rms(List<Integer> numbers) {
        double sumOfSquares = numbers.stream().mapToDouble(n -> n * n).sum();
        return Math.sqrt(sumOfSquares / numbers.size());
    }

    private Double am(List<Integer> numbers) {
        double sum = numbers.stream().mapToDouble(Integer::doubleValue).sum();
        return sum / numbers.size();
    }

    private Double gm(List<Integer> numbers) {
        double product = numbers.stream().mapToDouble(Integer::doubleValue).reduce((a, b) -> a * b).getAsDouble();
        return root(product, numbers.size());
    }

    private Double hm(List<Integer> numbers) {
        double sumOfReciprocals = numbers.stream().mapToDouble(n -> 1.0d / n).sum();
        return numbers.size() / sumOfReciprocals;
    }


    private static double root(double number, double degree) {
        return Math.pow(number, 1.0d / degree);
    }

}
