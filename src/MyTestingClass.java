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

    public void testPut() {
        myTable.put("Alice", "1");
        myTable.put("Bob", "2");
        myTable.put("Charlie", "3");
        System.out.println(myTable.get("Alice"));
        System.out.println(myTable.get("Bob"));
        System.out.println(myTable.get("Charlie"));
    }

    public void testRemove() {
        myTable.put("Sabina", "4");
        myTable.put("Alina","5");
        myTable.put("Eva", "6");
        myTable.put("Messi", "7");
        myTable.remove("Eva");
        System.out.println(myTable.get("Sabina"));
        System.out.println(myTable.get("Alina"));
        System.out.println(myTable.get("Messi"));
        System.out.println(myTable.get("Eva"));


    }

}