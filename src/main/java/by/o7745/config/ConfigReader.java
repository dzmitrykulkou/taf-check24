package by.o7745.config;

import org.aeonbits.owner.ConfigFactory;

public final class ConfigReader {
    private static final ConfigFramework CONFIG = ConfigFactory.create(ConfigFramework.class);

    public static ConfigFramework getConfig() {
        return CONFIG;
    }
}
