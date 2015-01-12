package blah;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public void run(MyConfiguration configuration, Environment environment) {
        environment.jersey().register(new SimpleResource());
        environment.jersey().register(new PathParamResource());
        environment.jersey().register(new QueryParamResource());
        environment.jersey().register(new PostResource());
        environment.jersey().register(new ListParamResource());
    }

}
