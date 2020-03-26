package net.nyasroryo.nfm.checking;

/**
 * I write the algorithm
 * this can check more fuzzy
 * example: 'qq12345' can match 'q/#q\.$1^:2&*'3`^4@5|!'
 * in fact, it's powerful than FuzzyChecker but
 * it's not very customizable
 * plz use RegexChecker more
 * 
 * @author NyasRoryo
 */
public final class EnhancedFuzzyChecker extends Checker{

  EnhancedFuzzyChecker(String checker){
    super( ".*".concat(String.join(".{0,3}", checker.split(""))).concat(".*"));
  }

  /**
   * no regex!
   * @param  msg a normal string
   * @return is the msg dirty
   */
  @Override
  public String check(String msg){
    return msg != null ? msg.replaceAll(checker, "[屏蔽]") : "null";
  }

}