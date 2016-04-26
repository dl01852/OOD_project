package com.ood.restaurant.commands;

import android.graphics.Color;
import android.widget.Button;

/**
 * Command to toggle the button states (enabled/disabled)
 * @author Michael Palmer
 */
public class ToggleButtonCommand {
    public void execute(Button button) {
        if (button.isEnabled()) {
            button.setTextColor(Color.GRAY);
        } else {
            button.setTextColor(Color.WHITE);
        }
        button.setEnabled(!button.isEnabled());
    }
}
