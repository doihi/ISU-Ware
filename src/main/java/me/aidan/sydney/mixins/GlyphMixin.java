package me.aidan.sydney.mixins;

import me.aidan.sydney.ISU;
import me.aidan.sydney.modules.impl.core.FontModule;
import net.minecraft.client.font.Glyph;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Glyph.class)
public interface GlyphMixin {
    @Inject(method = "getShadowOffset", at = @At("HEAD"), cancellable = true)
    private void getShadowOffset(CallbackInfoReturnable<Float> info) {
        if (ISU.MODULE_MANAGER != null && ISU.MODULE_MANAGER.getModule(FontModule.class).isToggled() && !ISU.MODULE_MANAGER.getModule(FontModule.class).shadowMode.getValue().equalsIgnoreCase("Default")) {
            info.setReturnValue(ISU.FONT_MANAGER.getShadowOffset());
        }
    }
}
