package com.mclegoman.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin (net.minecraft.item.Item.class)
public interface InventoryItem {
    @Mutable @Accessor void setMaxCount(int count);
}