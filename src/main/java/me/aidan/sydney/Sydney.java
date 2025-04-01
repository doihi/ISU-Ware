package me.aidan.sydney;

import me.aidan.sydney.commands.CommandManager;
import me.aidan.sydney.events.EventHandler;
import me.aidan.sydney.gui.ClickGuiScreen;
import me.aidan.sydney.managers.*;
import me.aidan.sydney.modules.ModuleManager;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sydney implements ModInitializer {
	public static final String MOD_NAME;
	public static final String MOD_ID;
	public static final String MOD_VERSION;
	public static final String MINECRAFT_VERSION;
	public static final long UPTIME = System.currentTimeMillis();

	public static final EventHandler EVENT_HANDLER = new EventHandler();
	public static final Logger LOGGER;

	public static ChatManager CHAT_MANAGER;
	public static FontManager FONT_MANAGER;
	public static FriendManager FRIEND_MANAGER;
	public static WorldManager WORLD_MANAGER;
	public static PositionManager POSITION_MANAGER;
	public static RotationManager ROTATION_MANAGER;
	public static ServerManager SERVER_MANAGER;
	public static RenderManager RENDER_MANAGER;
	public static TargetManager TARGET_MANAGER;
	public static MacroManager MACRO_MANAGER;
	public static TaskManager TASK_MANAGER;
	public static WaypointManager WAYPOINT_MANAGER;

	public static ModuleManager MODULE_MANAGER;
	public static CommandManager COMMAND_MANAGER;

	public static ShaderManager SHADER_MANAGER;
	public static ConfigManager CONFIG_MANAGER;

	public static ClickGuiScreen CLICK_GUI;

	@Override
	public void onInitialize() {
		CHAT_MANAGER = new ChatManager();
		FONT_MANAGER = new FontManager();
		FRIEND_MANAGER = new FriendManager();
		WORLD_MANAGER = new WorldManager();
		POSITION_MANAGER = new PositionManager();
		ROTATION_MANAGER = new RotationManager();
		SERVER_MANAGER = new ServerManager();
		RENDER_MANAGER = new RenderManager();
		TARGET_MANAGER = new TargetManager();
		MACRO_MANAGER = new MacroManager();
		TASK_MANAGER = new TaskManager();
		WAYPOINT_MANAGER = new WaypointManager();

		MODULE_MANAGER = new ModuleManager();
		COMMAND_MANAGER = new CommandManager();
	}

	public static void onPostInitialize() {
		SHADER_MANAGER = new ShaderManager();
		CONFIG_MANAGER = new ConfigManager();

		CLICK_GUI = new ClickGuiScreen();

		LOGGER.info("{} {} has been initialized.", MOD_NAME, MOD_VERSION);
	}

	static {
		MOD_NAME = "ISU-Ware";
		MOD_ID = "isu-ware";
		MOD_VERSION = "1.0.0";
		MINECRAFT_VERSION = "1.21.4";
		LOGGER = LoggerFactory.getLogger(MOD_NAME);
	}
}