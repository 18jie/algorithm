package os;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author fengjie
 * @date 2019:04:03
 */
public class LRU<K, V> {

    private int MAX_SIZE;
    private float LOAD_FACTORY = 0.75F;
    private LinkedHashMap<K, V> map;

    public LRU(int cacheSize) {
        MAX_SIZE = cacheSize;
        int capacity = (int) (Math.ceil(MAX_SIZE / LOAD_FACTORY) + 1);
        map = new LinkedHashMap<K, V>(capacity, LOAD_FACTORY, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_SIZE;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return map.entrySet();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (K key : map.keySet()) {
            str.append(key + " ");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        LRU<Integer, Integer> lru = new LRU<>(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru);
        lru.put(4, 4);
        System.out.println(lru);
        lru.put(1, 1);
        System.out.println(lru);
    }

}
