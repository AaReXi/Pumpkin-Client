package org.aarex.pumpkinc.client;

import net.fabricmc.api.ClientModInitializer;
import org.aarex.pumpkinc.client.keybind.ModKeyBinds;
import org.aarex.pumpkinc.client.keybind.KeybindHandler;

public class PumpkincClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModKeyBinds.register();
        KeybindHandler.register();
    }
}