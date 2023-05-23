package com.mclegoman.mixin;

import com.mclegoman.config.InventoryConfig;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class InventoryItemStackSize {
    @Shadow @Final private int maxCount;
    @Inject(method = "getMaxCount", at = @At("RETURN"), cancellable = true)
    private void getMaxCount(CallbackInfoReturnable<Integer> cir) {
        if (maxCount != 1) {
            if (maxCount == 16) cir.setReturnValue(getStack(InventoryConfig.MAX_STACK_MINI));
            cir.setReturnValue(getStack(InventoryConfig.MAX_STACK_DEFAULT));
        }
    }
    private static int getStack(int maxStack) {
        return Math.min(maxStack, 1073741823);
    }
}