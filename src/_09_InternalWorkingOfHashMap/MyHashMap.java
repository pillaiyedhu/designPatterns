package _09_InternalWorkingOfHashMap;

import java.util.Map;

public class MyHashMap<K,V> {

    private static final int INITIAL_SIZE = 1<<4;
    private static final int MAX_CAPACITY = 1<<30;

    public Entry[] hashTable;

    public MyHashMap(){
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

//    explanation for below method we did it because
//    we need to find the closest capacity with respect to 2s power eg: close to 10 is 16 means next greater
//    eg: n = 10   --> 1010
//    n>>>1 :   0101
//    n|n>>1 : 1010
//             0101
//            ------
//             1111
//
//    ans =  n|=n>>>1 = 15


    private int tableSizeFor(int capacity){
        int n = capacity-1;
        n|=n>>>1;
        n|=n>>>2;
        n|=n>>>4;
        n|=n>>>8;
        n|=n>>>16;

        return n<0 ? 1 : (n>=MAX_CAPACITY ? MAX_CAPACITY : n+1);
    }


    class Entry<K,V>{
        public K key;
        public V value;
        public Entry next;

        public Entry(K key , V value){
            this.key =key;
            this.value = value;
            next = null;
        }
    }

    public void put(K key , V value){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null){
            Entry newNode = new Entry(key,value);
            hashTable[hashCode]= newNode;
        }else{
            Entry previousNode = node;
            while(node != null){
                if(node.key==key){
                    node.value = value;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key,value);
            previousNode.next = newNode;
        }

    }

    public V get(K key){
        int hashcode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashcode];

        while(node!=null){
            if(node.key == key){
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }


    public static void main(String[] args) {
        MyHashMap<Integer,String> myMap = new MyHashMap<>();
        myMap.put(1,"hello");
        myMap.put(2,"bye");

        String ans = myMap.get(1);
        System.out.println(ans);
    }
}
