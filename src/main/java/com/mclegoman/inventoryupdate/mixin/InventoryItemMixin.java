package com.mclegoman.inventoryupdate.mixin;

import com.mclegoman.inventoryupdate.config.InventoryConfig;
import net.minecraft.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class InventoryItemMixin {
	@Inject(at = @At("RETURN"), method = "getMaxCount", cancellable = true)
	private void inventory_update$getMaxCount(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(InventoryConfig.MAX_STACK);
	}
}
