package demo1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-07
 * Time: 10:58
 */
public class HashBack {
    static class Node{
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    public Node[] array;
    public int usedSize;//存放了多少数据
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashBack(){
        array = new Node[10];
    }

    public void put(int key,int val){
        int index = key % array.length;
        //遍历index下标的链表，是否存在key 存在更新value，不存在插入数据
        Node cur = array[index];
        while (cur != null){
            if (cur.key == key){
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        // cur == null 遍历完 没有找到key
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;

        if (doLoadFactor() > DEFAULT_LOAD_FACTOR){
            // 扩容
//            array = Arrays.copyOf(array,2*array.length);
            resize();
        }
    }

    private void resize(){
        Node[] newArray = new Node[2*array.length];
        //遍历原来的数组
        for (int i = 0; i < array.length; i++){
            Node cur = array[i];
            while (cur != null){
                Node tmp = cur.next;
                int newIndex = cur.key % newArray.length;
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = tmp;
            }
        }
        array = newArray;
    }

    private float doLoadFactor(){
        return usedSize*1.0f / array.length;
    }

    public int get(int key){
        int index = key % array.length;
        //遍历index下标的链表，是否存在key 存在更新value，不存在插入数据
        Node cur = array[index];
        while (cur != null){
            if (cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}
