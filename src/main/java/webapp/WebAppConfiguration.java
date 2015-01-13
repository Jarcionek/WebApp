package webapp;

import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

public class WebAppConfiguration extends Configuration {

    @Getter @Setter public String name;

}
