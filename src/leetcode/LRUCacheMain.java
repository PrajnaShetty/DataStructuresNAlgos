package leetcode;

import java.util.Hashtable;


class LRUCache {

    private Hashtable<Integer, DNode> cache;
    private int size;
    private int capacity;
    private DNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache =  new Hashtable<>();

        head = new DNode(0, 0);
        tail = new DNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DNode node = cache.get(key);

        if (node == null) {
            DNode newNode = new DNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;

            if(size > capacity) {
                // pop the tail
                DNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }

        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }

    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;

        DNode(int k , int v) {
            key = k;
            value = v;
        }

        public String toString() {
            return "[" + key + " = " + value + "]" ;
        }
    }

    private void addNode(DNode node) {
        /*
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DNode node){
        /*
         * Remove an existing node from the linked list.
         */
        DNode prev = node.prev;
        DNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DNode node){
        /*
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DNode popTail() {
        /*
         * Pop the current tail.
         */
        DNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public void printCache() {
        DNode node = head;

        System.out.println(cache);

    }
}


public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);

        System.out.println(lruCache.get(1));
        lruCache.put(1, 11);
        System.out.println(lruCache.get(1));
        lruCache.put(2, 22);
        lruCache.put(3, 33);
        lruCache.put(4, 44);
        lruCache.put(5, 55);

        System.out.println(lruCache.get(1));
        lruCache.put(6, 55);

        lruCache.printCache();


    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */