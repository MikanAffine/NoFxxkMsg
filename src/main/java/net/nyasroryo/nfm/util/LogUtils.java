package net.nyasroryo.nfm.util;

import static net.nyasroryo.nfm.util.Constants.*;

import java.util.Arrays;

public final class LogUtils {

  private LogUtils() {}

  public static void log(String msg, String level){
    switch(level){
      default:
      case "info":
        logger.info(msg);
        break;
      case "warning":
        logger.warning(msg);
        break;
      case "severe":
        logger.severe(msg);
        break;
      case "fine":
        logger.fine(msg);
        break;
      case "finer":
        logger.finer(msg);
        break;
      case "finest":
        logger.finest(msg);
        break;
      case "config":
        logger.config(msg);
        break;
      case "debug":
        debug(msg);
        break;
    }
  }

  public static void log(String[] msgs, String level) {
    Arrays.<String>stream(msgs).forEach(msg -> log(msg, level));
  }

  public static void info(String msg){
    logger.info(msg);
  }

  public static void info(String[] msgs) {
    Arrays.<String>stream(msgs).forEach(logger::info);
  }

  public static void warning(String msg) {
    logger.warning(msg);
  }

  public static void warning(String[] msgs) {
    Arrays.<String>stream(msgs).forEach(logger::warning);
  }

  public static void severe(String msg) {
    logger.severe(msg); 
  }

  public static void severe(String[] msgs) {
    Arrays.<String>stream(msgs).forEach(logger::severe);
  }
  
  public static void debug(String msg) {
    if(isDebugging) logger.severe(msg);
  }

  public static void debug(String[] msgs) {
    if(isDebugging) Arrays.<String>stream(msgs).forEach(logger::severe);
  }

}
