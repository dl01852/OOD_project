package com.ood.restaurant;

public class Listeners {
    public interface OnCustomizeListener {
        void onCustomizeClicked(String itemName);
        void onOrderClicked();
    }
}
