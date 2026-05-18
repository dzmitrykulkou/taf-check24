package de.check24.core.config;

import de.check24.core.enums.BrowserType;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface FrameworkConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    BrowserType browser();

    @Key("timeout")
    @DefaultValue("10")
    int timeout();

    @Key("headless")
    @DefaultValue("false")
    boolean headless();

    @Key("baseUrl")
    @DefaultValue("https://www.check24.de/")
    String baseUrl();
}
