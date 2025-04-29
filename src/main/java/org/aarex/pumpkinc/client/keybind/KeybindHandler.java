package org.aarex.pumpkinc.client.keybind;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.aarex.pumpkinc.client.hud.ModHUD;

public class KeybindHandler {
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (ModKeyBinds.HudKey.wasPressed()) {
                handleHUDKey(client);
            }
        });
    }

private static void handleHUDKey(MinecraftClient client) {
    client.setScreen(new ModHUD());
}
}