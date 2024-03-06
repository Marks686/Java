import binarysearchtree.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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

    public static void main(String[] args) {

    }


//        Map<String,Integer> map2 = new HashMap<>();
}
