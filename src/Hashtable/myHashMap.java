package Hashtable;

import org.junit.Test;

/* 装载因子:就是hash表中已经存储的关键字个数，
与可以散列位置的比值，表征着hash表中的拥挤情况，一般而言，该值越大则越容易发生冲突，
 相应地ASL平均查找长度也增大*/
public class myHashMap {
   private int size;                            //当前容量
   private static int INIT_CAPACITY = 16;       //默认容量
   private Entry[] container;                   //实际存储数据的数组对象
   private static float LOAD_FACTOR = 0.75f;    //装载因素
   int max;                                     //能存的最大的数=capacity*factor

   @Test
   public void test(){
      long start = System.currentTimeMillis();
      for(int i=0;i<1000000;i++){
         this.put(""+i,i*10+"");
      }
      long end = System.currentTimeMillis();
      System.out.println("插入元素时间："+(end-start));
      System.out.println(this.get("98"));
   }
   public myHashMap(){
      max = (int)(INIT_CAPACITY * LOAD_FACTOR); //能存的最大的数
      container = new Entry[INIT_CAPACITY];     //开辟空间
   }
   class Entry{
      Entry next;                               //采用挂链法，也就是说同一个Hash码中的不同子元素，next存储下一个元素的地址
      String key;
      String value;
      int hash;
      Entry(String key,String value,int hash){
         this.key = key;
         this.value = value;
         this.hash = hash;
      }
   }

   /**
    *
    * @param hashcode key的哈希码
    * @param containerLength 容器的长度
    * @return 即将存储在容器中的索引号，不能保证唯一
    */
   public int indexFor(int hashcode,int containerLength){
      return hashcode & (containerLength-1);
   }

   /**
    *
    * @param entry 老元素
    * @param newentry 要加入的新元素
    */
   public void addEntryLast(Entry entry,Entry newentry){
      if(size>max){ //扩容
         reSize(this.container.length*4);
      }
      entry.next = newentry;
   }
   public void addEntryFirst(Entry newentry,int index,Entry[] table){
      if(size>max){
         reSize(this.container.length*4);
      }
      table[index] = newentry;
      newentry.next = null;
   }

   /**
    * Jdk源码自带
    * 防止尽量不重复
    * @param obj
    * @return 返回对象的hash码
    */
   public int hash(Object obj){
      int h = 0;
      h ^= obj.hashCode();
      h ^= (h>>>20)^(h>>>12);
      return h ^ (h>>>7)^(h>>>4);
      /*
      * 对于Integer
      * return k.hashCode()
      * 就可以
      * */
   }
   /**
    *
    * @param e 新对象
    * @param container 容器
    * @return 判断新对象是否在容器里
    */
   public boolean setEntry(Entry e,Entry[] container){
      int index = indexFor(e.hash,container.length);   //计算数组下标
      Entry temp = container[index];
      if(temp!=null){                                  //该索引元素存在，采用单向链表，将此元素放到该链表的最后。
         while(temp!=null){
            if(temp.key.equals(e.key)&&temp.hash==e.hash&&temp.value.equals(e.value)){
               return false;                           //判断新元素是否和容器元素相同
            }else if(temp.key!=e.key&&temp.value!=e.value){
               if(temp.next==null){
                  break;
               }
            }
            temp = temp.next;
         }
         //加入新元素到队尾
         addEntryLast(temp,e);
      }else {
         //加入新元素到队首
         addEntryFirst(e,index,container);
      }
      return true;
   }

   /**
    *
    * @param newSize 开辟新数组的大小，扩容
    */
   public void reSize(int newSize){
      this.max = (int)(newSize*LOAD_FACTOR);  //形成新的max值
      Entry[] newContainer = new Entry[newSize];
      for(int i=0;i<this.container.length;i++){
         Entry e = container[i];
         while (e!=null){
            setEntry(e,newContainer);
            e = e.next;
         }
      }
      this.container = newContainer;

   }
   /**
    * @param key 将要存储的键值
    * @param value 将要存储的值
    * @return
    */
   public boolean put(String key,String value){
      int hash = hash(key);
      Entry entry = new Entry(key,value,hash);
      if(setEntry(entry,container)){
         size++;
         return true;
      }
      return false;
   }
   public String get(String key){
      Entry entry = null;
      int hash = hash(key);
      int index = indexFor(hash,this.container.length);
      entry = this.container[index];
      if(entry==null){
         return null;
      }
      while(entry!=null){
         if(key.equals(entry.key)){
            return entry.value;
         }
         entry = entry.next;
      }
      return null;
   }
}
