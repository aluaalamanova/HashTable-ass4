# HashTable-ass4
### This repository contains a Java program that demonstrates the usage of a hash table data structure.Following classes are implemented:
1.MyHashTable
2.MyTestinglass
3.Student
# Description of methods
### MyHashTable:
1.put(K key, V value): This method adds a key-value pair to the hash table.
2.get(K key): This method retrieves the value associated with the given key.
3.remove(K key): This method removes the key-value pair associated with the given key.
4.contains(V value): This method checks if the hash table contains the given value.
5.getKey(V value): This method returns the key associated with the given value.
6.hash(K key): This method calculates the index of the HashNode in the array using the hash function.
7.getAll(): This method prints the number of entries in each bucket of the hash table.
### MyTestingClass:
1.testPut(): This method tests the put() method of MyHashTable by adding several key-value pairs to the hash table and then prints the values of the keys added.
2.testRemove(): This method tests the remove() method of MyHashTable by adding several key-value pairs to the hash table, then removing a key-value pair using the remove() method and then prints the value of the removed key.
3.testContains(): This method tests the contains() method of MyHashTable by adding several key-value pairs to the hash table, then checks if the hash table contains a value using the contains() method and then prints whether the hash table contains the value or not.
4.testGetKey(): This method tests the getKey() method of MyHashTable by adding several key-value pairs to the hash table, then gets the key associated with a value using the getKey() method and then prints the key.
5.testGetAll(): This method tests the getAll() method of MyHashTable by adding several key-value pairs to the hash table and then prints the number of entries in each bucket of the hash table.
### Solution
### MyHashTable:
```public int hash(K key) {
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
   
   ```
   
    
### MyTestingClass:
    
    
    ```//This method tests the put() method of MyHashTable by adding several key-value pairs to the hash table and then prints the values of the keys added.
    public void testPut() {
        myTable.put(1, "Alice");
        myTable.put(2, "Bob");
        myTable.put(3, "Charlie");
        System.out.println(myTable.get(1));
        System.out.println(myTable.get(2));
        System.out.println(myTable.get(3));
    }
    //This method tests the remove() method of MyHashTable by adding several key-value pairs to the hash table,then removing a key-value pair using the remove() method and then printing the values of the remaining keys.
    public void testRemove() {
        myTable.put(4, "Sabina");
        myTable.put(5, "Alina");
        myTable.put(6, "Eva");
        myTable.put(7, "Messi");
        myTable.remove(6);
        System.out.println(myTable.get(4));
        System.out.println(myTable.get(5));
        System.out.println(myTable.get(7));
        System.out.println(myTable.get(6));


    }
    //This method tests the contains() method of MyHashTable by adding several key-value pairs to the hash table,
    // * and then checking if the hash table contains certain values and printing the results.
    // */
    public void testContains(){
        myTable.put(8, "Aliya");
        myTable.put(9, "Beka");
        myTable.put(10, "Sanzhar");
        myTable.put(11, "Arsen");
        System.out.println("Students");
        System.out.println(myTable.get(8));
        System.out.println(myTable.get(9));
        System.out.println(myTable.get(10));
        System.out.println(myTable.get(11));
        System.out.println("Does it contain Arsen? " + myTable.contains("Arsen"));
        System.out.println("Does it contain Madina? " + myTable.contains("Madina"));
    }
    /**
     * This method tests the getKey() method of MyHashTable by adding several key-value pairs to the hash table,
     * and then retrieving the key of a certain value and printing it.
     */
    public void testGetKey(){
        myTable.put(12, "Meruert");
        myTable.put(13, "Aigerim");
        myTable.put(14, "Samat");
        myTable.put(15, "Abzal");
        System.out.println(myTable.getKey("Aigerim"));
        System.out.println(myTable.getKey("Meruert"));
    }
    public void testRandom(){
        putRandom();
        table.getAll();
    }
    public void putRandom(){
        for (int i = 0; i < 10000; i++) {
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(x, y);
            Student value = new Student("Student " + i, i);
            table.put(key, value);
        }
    }
```

