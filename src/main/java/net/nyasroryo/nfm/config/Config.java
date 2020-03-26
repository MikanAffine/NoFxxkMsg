package net.nyasroryo.nfm.config;

import java.io.File;
import java.util.*;

import org.bukkit.configuration.file.YamlConfiguration;

import net.nyasroryo.nfm.checking.Checker;

import static net.nyasroryo.nfm.util.Constants.*;

public final class Config{

  private static YamlConfiguration config;

  public static void init(){
    File f = new File(dataFolder, "config.yml");
    if(!f.exists()) main.saveResource("config.yml", true);
    config = YamlConfiguration.loadConfiguration(f);

    replacement = config.getString("antiSwear.replacement");
    reject = config.getBoolean("antiSwear.reject");

    punishType = config.getString("punish.type").toUpperCase();
    punishCount = config.getInt("punish.count");
    punishValue = config.getString("punish.value");

    ArrayList<Checker> checkers = new ArrayList<>();
    config.getMapList("rules").forEach(rule -> {
      checkers.add(Checker.getChecker((String) rule.get("type"), (String) rule.get("text")));
    });
    System.out.println(checkers);
    Checker.setupChecker(checkers);
  }

  public static String replacement;
  public static boolean reject;
  public static String punishType;
  public static int punishCount;
  public static String punishValue;


}
