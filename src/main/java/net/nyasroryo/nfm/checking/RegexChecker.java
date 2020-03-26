package net.nyasroryo.nfm.checking;

import net.nyasroryo.nfm.config.Config;

public final class RegexChecker extends Checker{

  RegexChecker(String checker){
    super(".*".concat(checker).concat(".*"));
  }

  @Override
  public String check(String msg){
    return msg != null ? msg.replaceAll(checker, Config.replacement) : "null";
  }

}
