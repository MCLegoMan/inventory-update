package com.mclegoman.inventoryupdate.mixin;

import com.mclegoman.inventoryupdate.config.InventoryConfig;
import com.mclegoman.inventoryupdate.util.InventoryUtils;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Slot.class)
public class InventorySlotMixin {
	@Inject(at = @At("RETURN"), method = "getMaxItemCount", cancellable = true)
	private void inventory_update$getMaxItemCount(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(InventoryUtils.getStack(InventoryConfig.MAX_STACK_DEFAULT));
	}
}
