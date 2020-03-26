package net.nyasroryo.nfm.checking;

import net.nyasroryo.nfm.config.Config;

/**
 * example checker: 'abcdef'
 * 1. 'abcdef'
 * 2. 'abcdefg'
 * 3. 'abddefg'
 * 1:true, 2:true 3:false
 */
public final class FuzzyChecker extends Checker{

  FuzzyChecker(String checker){
    super(checker);
  }

  @Override
  public String check(String msg){
    return msg != null ? msg.replace(checker, Config.replacement) : "null";
  }

}