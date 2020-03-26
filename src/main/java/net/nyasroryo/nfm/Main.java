package net.nyasroryo.nfm;

import org.bukkit.plugin.java.JavaPlugin;

import net.nyasroryo.nfm.listener.ChatListener;
import net.nyasroryo.nfm.command.ReloadCmd;
import net.nyasroryo.nfm.config.Config;

import static net.nyasroryo.nfm.util.Constants.*;
import static net.nyasroryo.nfm.util.LogUtils.*;

/**
 * NoFxxkMsg插件主类
 * @author MistyField DevTeam
 */
public class Main extends JavaPlugin{
  
  @Override
  public void onEnable() {
    loadConstants();
    info(new String[]{
      "=-=-=-=-= NoFxxkMsg =-=-=-=-=",
      "#         NFM 正在加载      #",
      "#      版本: 0.0.1-Alpha    #",
      "#      作者: NyasRoryo      #",
      "#  输入: /nfm help 查看帮助 #",
      "#        欢迎您的使用       #",
      "=-=-=-=-= 你好世界! =-=-=-=-=",
    });
    Config.init();
    pluginManager.registerEvents(new ChatListener(), this);
    server.getPluginCommand("nfmreload").setExecutor(new ReloadCmd());;
  }
  
  @Override
  public void onDisable() {
    info(new String[]{
      "=-=-=-=-= NoFxxkMsg =-=-=-=-=",
      "#         NFM 正在加载      #",
      "#      版本: 0.0.1-Alpha    #",
      "#      作者: NyasRoryo      #",
      "#        感谢您的使用       #",
      "=-=-=-=-= 再见世界! =-=-=-=-=",
    });
  }
  
}
