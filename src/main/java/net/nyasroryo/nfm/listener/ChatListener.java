package net.nyasroryo.nfm.listener;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import net.nyasroryo.nfm.checking.Checker;

import static net.nyasroryo.nfm.config.Config.*;

import java.util.*;

public final class ChatListener implements Listener {

  @SuppressWarnings("deprecation")
  @EventHandler(priority = EventPriority.MONITOR)
  public void onChat(AsyncPlayerChatEvent event){
    Player p = event.getPlayer();
    if(p.isOp()) return;
    String msg = event.getMessage();
    String checked = Checker.checkMsg(msg);
    if(msg.equals(checked)) return;
    p.sendMessage("§aNFM §9>> §r不可以说脏话!");
    event.setMessage(checked);
    if(reject) event.setCancelled(true);
    if(punishCount == 0) return;
    String name = p.getName().toString();
    int count = punishCounter.getOrDefault(name, 0) + 1;
    if(count<punishCount){
      punishCounter.put(name, count+1);
      return;
    }
    punishCounter.put(name, 0);
    switch(punishType){
      default:
        return;
      case "KICK":
        p.kickPlayer(punishValue);
        return;
      case "BAN":
        Bukkit.getBanList(BanList.Type.NAME).addBan(name, punishValue, 
          new Date(Date.UTC(2030, 1, 1, 0, 0, 0)), "NoFxxkMsg Plugin");
        return;
      case "CMD":
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), punishValue);
        return;
    }
  }

  /**
   * 惩罚计数器
   */
  private static final HashMap<String, Integer> punishCounter = new HashMap<>();

}
