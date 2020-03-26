package net.nyasroryo.nfm.checking;

import net.nyasroryo.nfm.config.Config;

/**
 * example checker: 'abcdef'
 * 1. 'abcdef'
 * 2. 'abcdefg'
 * 3. 'abddefg'
 * 1:true, 2:false, 3:false
 */
public final class FullMatchChecker extends Checker{

  FullMatchChecker(String checker){
    super(checker);
  }

  @Override
  public String check(String msg) {
    return checker.equalsIgnoreCase(msg) ? Config.replacement : msg;
  }

}