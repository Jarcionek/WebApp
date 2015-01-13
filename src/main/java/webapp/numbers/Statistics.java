package webapp.numbers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings({"UnusedDeclaration", "FieldCanBeLocal"})
public class Statistics {

    @JsonProperty("Numbers") private final List<Integer> numbers;
    @JsonProperty("Root Mean Square") private final double rms;
    @JsonProperty("Arithmetic Mean") private final double am;
    @JsonProperty("Geometric Mean") private final double gm;
    @JsonProperty("Harmonic Mean") private final double hm;

    public Statistics(List<Integer> numbers, double rms, double am, double gm, double hm) {
        this.numbers = numbers;
        this.rms = rms;
        this.am = am;
        this.gm = gm;
        this.hm = hm;
    }

}
