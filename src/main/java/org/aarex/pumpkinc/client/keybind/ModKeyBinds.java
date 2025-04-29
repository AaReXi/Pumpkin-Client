package org.aarex.pumpkinc.client.keybind;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ModKeyBinds {
    public static KeyBinding HudKey;

    public static void register() {
        HudKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.pumpkinc.HUD",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.pumpkinc.keybindsCategory"
        ));
    }
}