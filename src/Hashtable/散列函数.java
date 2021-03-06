package Hashtable;

public class 散列函数 {
   /**
    * 用来确定哈希码
    * 1.直接定址法:简单、均匀
    * f(key)=a*key+b
    * 2.数字分析法:适用于处理关键字位数比较大的情况，如果事先知道关键字的分布均匀且关键字的若干分布较均匀。
    * 3.平方取中法:适用于不知道关键字分布，而位数又不是很大
    * 1234 平方 1522756 则散列地址为1522756中任意连续三位数
    * 4.除留余数法:
    * 散列表长为m
    * f(key)=key mod p (p<=m)
    * 通常p为小于等于m的最小质数或不包含小于20质因子的合数
    * 5.随机数法:
    * f(key)=random(key)
    * 如果key是字符串或者特殊符号，可以使用其ACSll码或Unicode码计算其哈希码
    * 6.折叠法:实现不需要知道关键字的分布，适合关键字位数较大的情况
    * 9876543210
    * 987|654|321|0
    * 987+654+321+0 = 1962
    * 散列地址为后三位962
    *
    * 采用散列函数的因素
    * 1.计算散列地址所需时间
    * 2.关键字的长度
    * 3.散列表的大小
    * 4.关键字的分布情况
    * 5.记录查询频率
    */

   /**
    * 处理散列冲突
    * key1 != key2 , 如果f(key1)=f(key2)
    * 1.开放定址法:一旦发生冲突，就去寻找下一个空的散列地址，只要散列表足够大，空的散列地址总能找到，并将记录存入
    * 线性探测法
    * 公式：
    * fi(key)=(f(key)+di) mod m (dj=1,2,3,4...m-1)
    * 我们把不是同义词却需要争夺一个地址的情况称为堆积，堆积的产生需要我们不断的处理冲突，因此无论是存入还是
    * 还是查找效率都会大大降低
    * 2.在散列函数
    * 3.链地址法
    *
    *
    */
}
