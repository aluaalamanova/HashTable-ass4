import java.util.Random;

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
    public void testPut(){
        myTable.put("Alice", 221523);
        myTable.put("Bob", 224330);
        myTable.put("Charlie", 226535);
        System.out.println(myTable.get("Alice"));
        System.out.println(myTable.get("Bob"));
        System.out.println(myTable.get("Charlie"));
    }


}