package org.aarex.pumpkinc;

import net.fabricmc.api.ModInitializer;
import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pumpkinc implements ModInitializer {
    public static final String MOD_ID = "pumpkinc";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        LOGGER.info("PumpkinC is ready to rock!");
    }
}