package com.mclegoman;

import com.mclegoman.config.InventoryConfig;
import net.fabricmc.api.ModInitializer;

public class InventoryMain implements ModInitializer {
    @Override
    public void onInitialize() {
        InventoryConfig.registerConfigs();
    }
}