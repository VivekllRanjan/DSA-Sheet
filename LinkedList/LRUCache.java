package LinkedList;

import java.util.HashMap;

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private int cap;
    Node left, right; //Left-> Less used, Right -> Most used ==> Delete Left if number of keys > cap
    HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;

        //Use Hashmap to store key value pair
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode); //New entry to the right of LL

        if(cache.size() > cap) {
            Node lru = this.left.next;
            remove(lru); //Remove Left most
            cache.remove(lru.key); //Remove from HashMap
        }
    }

    private void remove(Node curr) {
        Node prev = curr.prev;
        Node nxt = curr.next;
        prev.next = curr.next;
        nxt.prev = prev;
    }
    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */