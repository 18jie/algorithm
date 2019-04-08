package os;

import java.util.HashMap;

/**
 * @author fengjie
 * @date 2019:04:03
 */
public class LRU1<K, V> {
    private static int MAX_CACHE_SIZE;
    private Entry<K, V> head;
    private Entry<K, V> tail;

    private HashMap<K, Entry<K, V>> cache;

    public LRU1(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        cache = new HashMap<>();
    }

    public void put(K key, V value) {
        Entry<K, V> entry = this.getEntry(key);
        if (entry == null) {
            if (cache.size() >= MAX_CACHE_SIZE) {
                cache.remove(tail.key);
                this.removeTail();
            }
            entry = new Entry<>();
            entry.key = key;
            entry.value = value;
            this.moveToHead(entry);
            cache.put(key, entry);
        } else {
            entry.value = value;
            this.moveToHead(entry);
        }
    }

    public V get(K key) {
        Entry<K, V> entry = this.getEntry(key);
        if (entry == null) {
            return null;
        }
        this.moveToHead(entry);
        return entry.value;
    }

    public void remove(K key) {
        Entry<K, V> entry = this.getEntry(key);
        if (entry != null) {
            if (entry == head) {
                head = head.next;
                entry.next = null;
                head.pre = null;
            } else if (entry == tail) {
                tail = tail.pre;
                entry.pre = null;
                tail.next = null;
            } else {
                entry.pre.next = entry.next;
                entry.next.pre = entry.pre;
                entry.next = null;
                entry.pre = null;
            }
            cache.remove(key);
        }
    }

    private void moveToHead(Entry<K, V> entry) {
        if (entry == null) {
            return;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry == tail) {
            Entry<K, V> pre = entry.pre;
            if (pre != null) {
                tail.pre = null;
                tail = pre;
                tail.next = null;
            }
        }

        if (head == null || tail == null) {
            head = tail = entry;
            return;
        }

        entry.next = head;
        head.pre = entry;
        entry.pre = null;
        head = entry;
    }

    private void removeTail() {
        if (tail != null) {
            Entry<K, V> pre = this.tail.pre;
            if (pre == null) {
                head = null;
                tail = null;
            } else {
                tail.pre = null;
                tail = pre;
                tail.next = null;
            }
        }
    }

    private Entry<K, V> getEntry(K key) {
        return cache.get(key);
    }

    private static class Entry<K, V> {
        Entry<K, V> pre;
        Entry<K, V> next;
        K key;
        V value;
    }

}
