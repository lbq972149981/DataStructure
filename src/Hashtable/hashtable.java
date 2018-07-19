package Hashtable;

public class hashtable {
   /**
    * HashCode返回对象存储的物理地址
    * HashCode码相同，才调用equals()方法
    * Hash表几个特性：
    * 1.同一个对象调用equals()多次，该对象调用hashCode多次，必须返回同一个整数
    * 2.如果两个对象根据equals(Object o)方法是相等的，则调用两个对象中的任意一个对象的hashCode方法
    * 必须产生相同的结果
    * 3.如果两个对象根基equals(Object o)方法是不相等的，两个对象的HashCode尽可能不同，提高散列表的性能
    * 4.两个相等对象的equals()方法为true,但是两个hashCode相等的对象不一定是相等对象
    * HashCode值相等只能保证两个对象在一个Hash表里的同一条Hash链上，继而根据equals()方法确定是不是同一个对象。
    */
   /**
    * Java对HashCode与equals()的规定
    * 1.如果两个对象相同，则它们的hashCode一定相同
    * 2.如果两个对象的HashCode相同，则它们不一定相同
    */
}
