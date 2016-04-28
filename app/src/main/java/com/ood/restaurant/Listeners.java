package com.ood.restaurant;

/**
 * Listeners
 */
public class Listeners {
    /**
     * Listener that is triggered when the customize button is selected
     */
    public interface OnCustomizeListener {
        /**
         * Handle click events by the Customize button
         * @param itemName Item to be customized
         */
        void onCustomizeClicked(String itemName);
    }
}
