package com.vvaka;

import com.vvaka.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardk8s2Application extends Application<DropWizardk8s2Configuration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardk8s2Application().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-k8s2";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardk8s2Configuration> bootstrap) {


        System.out.println("================Environment==============");
        System.out.println(System.getenv());

        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor()
                )
        );

        // TODO: application initialization
    }

    @Override
    public void run(final DropWizardk8s2Configuration configuration,
                    final Environment environment) {

        environment.jersey().register(new HelloResource(configuration.getOtherAppUrl()));
    }

}
