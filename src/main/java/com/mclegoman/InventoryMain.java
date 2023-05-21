package com.mclegoman;

import com.mclegoman.config.InventoryConfig;
import com.mclegoman.mixin.InventoryItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class InventoryMain implements ModInitializer {
    @Override
    public void onInitialize() {
        InventoryConfig.registerConfigs();
        for (Item item : Registries.ITEM) {
            if (item.getMaxCount() != 1) {
                if (item.getMaxCount() == 16) ((InventoryItem) item).setMaxCount(InventoryConfig.MAX_STACK_MINI);
                else ((InventoryItem) item).setMaxCount(InventoryConfig.MAX_STACK_DEFAULT);
            }
        }
    }
}