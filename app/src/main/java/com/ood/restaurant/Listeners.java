package com.ood.restaurant;

public class Listeners {
    public interface OnCustomizeListener {
        void onCustomizeClicked(String itemName); // variable string itemName?
        void onOrderClicked();
    }

    public interface OnCustomizeAddListener
    {
        void onCustomizeClicked(String decoratorName);
    }
}
