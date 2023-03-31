package com.demoblaze.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config/api-config.properties"
})
public interface ApiConfig extends Config {

    @Key("url")
    String url();

    @Key("login")
    String loginEndpoint();

    @Key("signup")
    String signUpEndpoint();

}
