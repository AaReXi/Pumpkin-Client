package org.aarex.pumpkinc.client.hud;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class ModHUD extends Screen {
    // Colors (now using full opacity for backgrounds)
    private static final int BACKGROUND_COLOR = 0xFF000000; // Solid black
    private static final int HEADER_COLOR = 0xFF3C8527;    // Green header
    private static final int BUTTON_COLOR = 0xFF2C6517;    // Darker green for button
    private static final int BUTTON_HOVER_COLOR = 0xFF367D1D; // Lighter green for hover
    private static final int TEXT_COLOR = 0xFFFFFFFF;      // White text
    
    // GUI dimensions
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;
    
    // Button properties
    private static final int BUTTON_HEIGHT = 20;
    private static final int BUTTON_WIDTH = 100;
    private boolean isButtonHovered = false;
    
    private int buttonX;
    private int buttonY;

    public ModHUD() {
        super(Text.literal("Pumpkin Client"));
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        // Render the dark background overlay
        renderBackground(drawContext, mouseX, mouseY, delta);

        // Calculate center position
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        
        // Draw the main panel background
        drawContext.fill(x, y, x + WIDTH, y + HEIGHT, BACKGROUND_COLOR);
        
        // Draw header
        drawContext.fill(x, y, x + WIDTH, y + 30, HEADER_COLOR);
        drawContext.drawCenteredTextWithShadow(textRenderer, "Pumpkin Client", 
            x + WIDTH / 2, y + 10, TEXT_COLOR);
        
        // Calculate and store button position
        buttonX = x + (WIDTH - BUTTON_WIDTH) / 2;
        buttonY = y + 70;
        
        // Update button hover state
        isButtonHovered = mouseX >= buttonX && mouseX <= buttonX + BUTTON_WIDTH &&
                         mouseY >= buttonY && mouseY <= buttonY + BUTTON_HEIGHT;
        
        // Draw test button with clear edges
        drawContext.fill(
            buttonX, buttonY,
            buttonX + BUTTON_WIDTH, buttonY + BUTTON_HEIGHT,
            isButtonHovered ? BUTTON_HOVER_COLOR : BUTTON_COLOR
        );
        
        // Draw button text
        drawContext.drawCenteredTextWithShadow(textRenderer, "Test Button",
            buttonX + BUTTON_WIDTH / 2, buttonY + 6, TEXT_COLOR);

        super.render(drawContext, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (isButtonHovered) {
            if (client != null && client.player != null) {
                client.player.sendMessage(Text.literal("hi"), false);
            }
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}