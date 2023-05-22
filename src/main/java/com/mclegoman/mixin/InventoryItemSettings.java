package com.mclegoman.mixin;

import com.mclegoman.config.InventoryConfig;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = Item.Settings.class)
public abstract class InventoryItemSettings {
    @ModifyVariable(method = "maxCount", at = @At("HEAD"), argsOnly = true)
    private int maxCount(int maxCount) {
        if (maxCount != 1) {
            if (maxCount == 16) return InventoryConfig.MAX_STACK_MINI;
            else return InventoryConfig.MAX_STACK_DEFAULT;
        }
        else return maxCount;
    }
}