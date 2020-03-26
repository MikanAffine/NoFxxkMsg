package net.nyasroryo.nfm.util;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.scheduler.BukkitScheduler;

import net.nyasroryo.nfm.Main;

/**
 * 常量声明
 */
public final class Constants {
  
  private Constants(){}

  public static Main main = null;
  public static File dataFolder = null;
  public static Server server = null;
  public static Logger logger = null;
  public static PluginManager pluginManager = null;
  public static ServicesManager serviceManager = null;
  public static PluginLoader pluginLoader = null;
  public static BukkitScheduler scheduler = null;
  public static ConsoleCommandSender console = null;
  public static ClassLoader classLoader = null;

  public static final boolean isDebugging = true;

  /**
   * 给常量赋值
   */
  public static void loadConstants(){
    main = (Main) Bukkit.getPluginManager().getPlugin("NoFxxkMsg");
    dataFolder = main.getDataFolder();
    server = main.getServer();
    logger = main.getLogger();
    pluginLoader = main.getPluginLoader();
    pluginManager = server.getPluginManager();
    scheduler = server.getScheduler();
    console = server.getConsoleSender();
    classLoader = Main.class.getClassLoader();
}

}
