package webapp;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class WebApp extends Application<WebAppConfiguration> {

    public static void main(String[] args) throws Exception {
        new WebApp().run(args);
    }

    @Override
    public void run(WebAppConfiguration configuration, Environment environment) {
        environment.jersey().register(new SimpleResource());
        environment.jersey().register(new PathParamResource());
        environment.jersey().register(new QueryParamResource());
        environment.jersey().register(new PostResource());
        environment.jersey().register(new ListParamResource());
    }

}
