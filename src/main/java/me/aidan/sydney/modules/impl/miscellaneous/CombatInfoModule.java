package me.aidan.sydney.modules.impl.miscellaneous;

import me.aidan.sydney.ISU;
import me.aidan.sydney.events.SubscribeEvent;
import me.aidan.sydney.events.impl.RenderOverlayEvent;
import me.aidan.sydney.modules.Module;
import me.aidan.sydney.modules.RegisterModule;
import me.aidan.sydney.modules.impl.combat.AutoCrystalModule;
import me.aidan.sydney.modules.impl.combat.KillAuraModule;
import me.aidan.sydney.modules.impl.core.HUDModule;
import me.aidan.sydney.settings.impl.BooleanSetting;
import me.aidan.sydney.settings.impl.StringSetting;
import me.aidan.sydney.utils.minecraft.HoleUtils;
import net.minecraft.item.Items;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RegisterModule(name = "CombatInfo", description = "Shows useful combat information on screen.", category = Module.Category.MISCELLANEOUS)
public class CombatInfoModule extends Module {
    public StringSetting watermark = new StringSetting("Watermark", "The client name that will be rendered.", ISU.MOD_NAME);
    public BooleanSetting version = new BooleanSetting("Version", "Renders the client's version after the name.", true);

    @SubscribeEvent
    public void onRenderOverlay(RenderOverlayEvent event) {
        if(getNull()) return;

        HUDModule hudModule = ISU.MODULE_MANAGER.getModule(HUDModule.class);

        List<InfoEntry> entries = new ArrayList<>();
        AutoCrystalModule ca = ISU.MODULE_MANAGER.getModule(AutoCrystalModule.class);
        KillAuraModule ka = ISU.MODULE_MANAGER.getModule(KillAuraModule.class);
        int y = mc.getWindow().getScaledHeight() / 2, totems = mc.player.getInventory().count(Items.TOTEM_OF_UNDYING);

        entries.add(new InfoEntry(watermark.getValue() + (version.getValue() ? " " + ISU.MOD_VERSION : ""), null));
        entries.add(new InfoEntry("HTR", getColor(ka.getTarget() != null && mc.player.distanceTo(ka.getTarget()) < ka.range.getValue().floatValue())));
        entries.add(new InfoEntry("PLR", getColor(ca.getTarget() != null && mc.player.distanceTo(ca.getTarget()) < ca.enemyRange.getValue().floatValue())));
        entries.add(new InfoEntry(totems + "", getColor(totems > 0)));
        entries.add(new InfoEntry("PING " + ISU.SERVER_MANAGER.getPing(), getColor(ISU.SERVER_MANAGER.getPing() < 100)));
        entries.add(new InfoEntry("LBY", getColor(HoleUtils.isPlayerInHole(mc.player))));

        int offset = 0;
        for(InfoEntry entry : entries) {
            hudModule.drawText(event.getContext(), entry.text(), 2, y - (3*ISU.FONT_MANAGER.getHeight()) + (offset*ISU.FONT_MANAGER.getHeight()), entry.text().startsWith(watermark.getValue()) && hudModule.colorMode.getValue().equals("Rainbow") && hudModule.rainbowMode.getValue().equals("Horizontal"), entry.color());
            offset++;
        }
    }

    private Color getColor(boolean toggled) {
        return toggled ? new Color(100, 255, 100) : new Color(255, 100, 100);
    }

    public record InfoEntry(String text, Color color) {}
}
