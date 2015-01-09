package blah;

import io.dropwizard.Configuration;

public class HelloWorldConfiguration extends Configuration {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
