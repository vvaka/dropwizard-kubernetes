package com.vvaka;

import com.vvaka.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardK8S1Application extends Application<DropWizardK8S1Configuration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardK8S1Application().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-k8s1";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardK8S1Configuration> bootstrap) {


        System.out.println("================Environment==============");
        System.out.println(System.getenv());

        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        // TODO: application initialization
    }

    @Override
    public void run(final DropWizardK8S1Configuration configuration,
                    final Environment environment) {

        environment.jersey().register(new HelloResource(configuration.getOtherAppUrl()));

    }

}
