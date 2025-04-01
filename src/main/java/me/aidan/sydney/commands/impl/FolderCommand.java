package me.aidan.sydney.commands.impl;

import me.aidan.sydney.ISU;
import me.aidan.sydney.commands.Command;
import me.aidan.sydney.commands.RegisterCommand;
import net.minecraft.util.Util;

import java.io.File;

@RegisterCommand(name = "folder", description = "Opens the clients folder.")
public class FolderCommand extends Command {
    @Override
    public void execute(String[] args) {
        File folder = new File(ISU.MOD_NAME);
        if (folder.exists()) {
            Util.getOperatingSystem().open(folder);
        } else {
            ISU.CHAT_MANAGER.info("Could not find the client's configuration folder.");
        }
    }
}
