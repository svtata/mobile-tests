package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:remote.properties"
})
public interface RemoteConfig extends Config {
    @Key("driverUrl")
    String getDriverUrl();

    @Key("BROWSERSTACK_USER")
    String getBrowserstackUser();

    @Key("BROWSERSTACK_KEY")
    String getBrowserstackKey();

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}
