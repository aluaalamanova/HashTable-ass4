public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key) {
            int hash = 0;
            String str = key.toString();

            for (int i = 0; i < str.length(); i++) {
                hash = 31 * hash + str.charAt(i);
            }

            return hash;
        }
    public void put(K key, V value) {
        int hashIndex = hash(key);
        HashNode<K, V> node = chainArray[hashIndex];

        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = chainArray[hashIndex];
        chainArray[hashIndex] = newNode;
        size++;
    }
    public V get(K key) {
        int hashIndex = hash(key);
        HashNode<K, V> node = chainArray[hashIndex];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }
    public V remove(K key) {
        int hashIndex = hash(key);
        HashNode<K, V> node = chainArray[hashIndex];
        HashNode<K, V> previousNode = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (previousNode == null) {
                    chainArray[hashIndex] = node.next;
                } else {
                    previousNode.next = node.next;
                }
                size--;
                return node.value;
            }
            previousNode = node;
            node = node.next;
        }

        return null;
    }
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
}