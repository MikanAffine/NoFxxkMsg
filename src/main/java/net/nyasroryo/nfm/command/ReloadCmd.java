package net.nyasroryo.nfm.command;

import org.bukkit.command.*;

import net.nyasroryo.nfm.config.Config;

public final class ReloadCmd implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(!sender.isOp()) return true;
    if(!"nfmreload".equalsIgnoreCase(label)) return true;
    Config.init();
    sender.sendMessage("§aNFM §9>> §r已重载");
    return true;
  }

}