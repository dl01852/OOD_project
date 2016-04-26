package com.ood.restaurant;

import android.widget.Button;

public class Listeners {
    public interface OnCustomizeListener {
        void onCustomizeClicked(String itemName); // variable string itemName?
        void onOrderClicked();
    }

    public interface OnCustomizeAddListener
    {
        void onCustomizeAddClicked(String decoratorName);
    }
}
