package ccf;

import java.util.*;

public class 出现次数最多的数 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Map<Integer,Integer> map = new TreeMap<>();
      //10 1 10 20 30 20
      int count = 0;
      int t = 0;
      while(n>0){
         int num = sc.nextInt();
         if(map.get(num)!=null){
            t = map.get(num);
            map.put(num,++t);
         }else {
            map.put(num,1);
         }
         n--;
      }
      int v = 0;
      Map<Integer,Integer> map1 = new TreeMap<>();
      Map<Integer,Integer> remap = sortMapByValue(map);
      for(Integer va : remap.values()){
         v = va;
         break;
      }
      for(Map.Entry<Integer,Integer> entry:remap.entrySet()){

         if(entry.getValue()!=v){
            break;
         }
         map1.put(entry.getKey(),entry.getValue());
      }
      for(Integer re:map1.keySet()){
         System.out.println(re);
         break;
      }
   }
   public static Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> oriMap) {
      if (oriMap == null || oriMap.isEmpty()) {
         return null;
      }
      Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
      List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(oriMap.entrySet());
      Collections.sort(entryList, new MapValueComparator());
      Iterator<Map.Entry<Integer, Integer>> iter = entryList.iterator();
      Map.Entry<Integer, Integer> tmpEntry = null;
      while (iter.hasNext()) {
         tmpEntry = iter.next();
         sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
      }
      return sortedMap;
   }
}
class MapValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

   @Override
   public int compare(Map.Entry<Integer, Integer> me1, Map.Entry<Integer, Integer> me2) {

      return me2.getValue().compareTo(me1.getValue());
   }
}