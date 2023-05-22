package com.mclegoman.mixin;

import com.mclegoman.config.InventoryConfig;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = FabricItemSettings.class)
public abstract class InventoryFabricItemSettings {
    @ModifyVariable(method = "maxCount(I)Lnet/minecraft/item/Item$Settings;", at = @At("RETURN"), argsOnly = true)
    private int maxCount(int maxCount) {
        if (maxCount != 1) {
            if (maxCount == 16) return InventoryConfig.MAX_STACK_MINI;
            else return InventoryConfig.MAX_STACK_DEFAULT;
        }
        else return maxCount;
    }
}