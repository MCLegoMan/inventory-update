package com.mclegoman.inventoryupdate;

import com.mclegoman.inventoryupdate.config.InventoryConfig;
import net.fabricmc.api.ModInitializer;

public class InventoryMain implements ModInitializer {
    @Override
    public void onInitialize() {
        InventoryConfig.registerConfigs();
    }
}