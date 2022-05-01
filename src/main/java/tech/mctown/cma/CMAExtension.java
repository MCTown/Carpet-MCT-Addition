package tech.mctown.cma;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CMAExtension implements CarpetExtension {
    public static final CMAExtension INSTANCE = new CMAExtension();
    public static final String MODID = "CMA";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public String version() {
        return MODID;
    }

    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(CMASettings.class);
    }
}
