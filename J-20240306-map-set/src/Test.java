import binarysearchtree.BinarySearchTree;
import demo1.HashBack;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-06
 * Time: 19:35
 */
public class Test {
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {5,12,3,2,11,15};
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
       System.out.println("----------");
       System.out.println(binarySearchTree.search(12));
        binarySearchTree.remove(12);
        System.out.println("========");
        System.out.println(binarySearchTree.search(12));
    }

    public static void main2(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("sunny",3);
        map.put("the",5);
        map.put("hello",2);

        Integer val = map.get("the");
        Integer val1 = map.getOrDefault("the2",000);

        System.out.println(val);
        System.out.println(val1);


        Set<String> set = map.keySet();
        System.out.println(set);

        System.out.println("===========");

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();//将key和value看成一个整体
        for (Map.Entry<String,Integer> entry : entrySet){
            System.out.println("key: "+ entry.getKey() + "value: "+ entry.getValue());
        }
    }

    public static void main3(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("sunny");
        set.add("hello");
        set.add("the");
        System.out.println(set);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        HashBack hashBack = new HashBack();
        hashBack.put(1,11);
        hashBack.put(2,22);
        hashBack.put(9,99);

        System.out.println(hashBack.get(9));
    }


}
