package com.mclegoman.inventoryupdate.util;

import com.mclegoman.inventoryupdate.config.InventoryConfig;

public class InventoryUtils {
    public static int getStack(int maxStack) {
        if (!InventoryConfig.REMOVE_LIMIT) return Math.min(maxStack, 1073741823);
        return maxStack;
    }
}
