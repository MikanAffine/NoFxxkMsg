package net.nyasroryo.nfm.checking;

import java.util.ArrayList;

public abstract class Checker {
  
  private static ArrayList<Checker> checkers = new ArrayList<>();

  public static void setupChecker(ArrayList<Checker> cks) {
    checkers = cks;
  }

  /**
   * 检测是否有脏话
   * 
   * @param msg 信息
   * @return 处理过的信息,如果有不同是会变成另一个字符串的
   */
  public static String checkMsg(String msg) {
    for (Checker c : checkers) {
      msg = c.check(msg);
    }
    return msg;
  }

  /**
   * Checker的工厂函数
   */
  public static Checker getChecker(String type,String text){
    switch(type.toUpperCase()){
      case "FULL":
      default:
        return new FullMatchChecker(text);
      case "REGEX":
        return new RegexChecker(text);
      case "FUZZY":
        return new FuzzyChecker(text);
      case "ENHANCED":
        return new EnhancedFuzzyChecker(text);
    }
  }

  /// 以下是实例方法之类的 ///

  protected final String checker;

  /**
   * 初始化一个检测器
   * @param s 用来检测是否有脏话的文本
   */
  public Checker(String s){
    checker = s == null ? "null" : s;
  }

  /**
   * 检测消息是不是脏的
   * @param msg 消息
   * @return 把脏话替换成屏蔽字符之后的信息
   */
  public String check(String msg){
    return msg;
  }

  @Override
  public String toString(){
    return this.getClass().getSimpleName() + "(" + checker + ")";
  }

}