package by.o7745.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ConfigFramework extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("timeout")
    @DefaultValue("10")
    int timeout();

    @Key("baseUrl")
    @DefaultValue("https://7745.by/")
    String baseUrl();
}
