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

    // array to hold the chain of HashNodes
    private HashNode<K, V>[] chainArray;

    // default array size and number of elements in the array
    private int M = 11;
    private int size;

    // constructor with default array size
    public MyHashTable() {
        this.chainArray = new HashNode[ this.M];
        size = 0;
    }

    // constructor with user-defined array size
    public MyHashTable(int M) {
        this.M = M;
        this.chainArray = new HashNode[ this.M];
        size = 0;
    }

    // hash function to calculate the index of the HashNode in the array
    public int hash(K key) {
        int hash = 0;
        String str = key.toString();

        for (int i = 0; i < str.length(); i++) {
            hash = 31 * hash + str.charAt(i);
        }

        return hash%this.M;
    }

    // adds a key-value pair to the hash table
    public void put(K key, V value) {
        int hashIndex = hash(key);
        HashNode<K, V> node = chainArray[hashIndex];

        // if the key is already present, update the value
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        // if the key is not already present, add it to the chain
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = chainArray[hashIndex];
        chainArray[hashIndex] = newNode;
        size++;
    }

    // retrieves the value associated with the given key
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

    // removes the key-value pair associated with the given key
    public V remove(K key) {
        int hashIndex = hash(key);
        HashNode<K, V> node = chainArray[hashIndex];
        HashNode<K, V> previousNode = null;

        while (node != null) {
            if (node.key.equals(key)) {
                // remove the node from the chain
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

    // checks if the hash table contains the given value
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

    // Returns the key associated with the given value.
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
    public void replace(K key, V value, V newValue){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value =null;
                    node.value=newValue;
                }
                node = node.next;
            }
        }
    }
    //Prints the number of entries in each bucket of the hash table.
    public void getAll(){
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println("Bucket " + i + ": " + count + " entries");
        }
    }
}