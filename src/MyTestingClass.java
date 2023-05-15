import java.util.Random;
//Constructor for MyTestingClass, takes two integer parameters x and y and assigns them to class variables
public class MyTestingClass {
    private int x;
    private int y;
    MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
    MyHashTable myTable = new MyHashTable();
    Random random = new Random();

    public MyTestingClass(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //This method tests the put() method of MyHashTable by adding several key-value pairs to the hash table and then prints the values of the keys added.
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
}

