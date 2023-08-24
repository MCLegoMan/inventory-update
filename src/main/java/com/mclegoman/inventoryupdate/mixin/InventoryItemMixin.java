package com.mclegoman.inventoryupdate.mixin;

import com.mclegoman.inventoryupdate.config.InventoryConfig;
import com.mclegoman.inventoryupdate.util.InventoryUtils;
import net.minecraft.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class InventoryItemMixin {
	@Shadow protected int maxCount;

	@Inject(at = @At("RETURN"), method = "getMaxCount", cancellable = true)
	private void inventory_update$getMaxCount(CallbackInfoReturnable<Integer> cir) {
		if (maxCount != 1) {
			if (maxCount == 16) cir.setReturnValue(InventoryUtils.getStack(InventoryConfig.MAX_STACK_MINI));
			cir.setReturnValue(InventoryUtils.getStack(InventoryConfig.MAX_STACK_DEFAULT));
		}
	}
}
