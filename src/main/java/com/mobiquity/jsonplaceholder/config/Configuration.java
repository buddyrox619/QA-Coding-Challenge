package com.mobiquity.jsonplaceholder.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration.properties"})
public interface Configuration extends Config {

    @Key("api.base.uri")
    String baseURI();

}