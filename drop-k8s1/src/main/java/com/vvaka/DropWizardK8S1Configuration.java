package com.vvaka;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DropWizardK8S1Configuration extends Configuration {

    @Valid
    @NotNull
    String otherAppUrl;


    @JsonProperty("otherAppUrl")
    public String getOtherAppUrl() {
        return otherAppUrl;
    }

    public void setOtherAppUrl(String otherAppUrl) {
        this.otherAppUrl = otherAppUrl;
    }

}



