package Top150;

import java.util.ArrayList;
import java.util.HashMap;

// 146
public class LRUCache {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list;
    int capacity;
    public LRUCache(int capacity) {
        list = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            System.out.println(-1);
            return -1;
        }
        list.remove(Integer.valueOf(key));
        list.add(key);
        System.out.println(map.get(key));
        return map.get(key);
    }

    public void put(int key, int value) {
        // 1 exist: re-order
        if (map.containsKey(key)) {
            // remove
            list.remove(Integer.valueOf(key));
            map.remove(key);
            // call put again
            put(key,value);
            return;
        }
        // 2 not exist, full: remove, add
        if (list.size() == capacity ) {
            // handle remove
            int k = list.remove(0);
            map.remove(k);
        }
        // 3 not exist, not full: add
        map.put(key, value);
        list.add(key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }
}
