public class Student {
    private String name;
    private int id;

    public Student(String name, int age) {
        this.name = name;
        this.id = id;
    }
    public int hashCode() {
        int hash = 3;
        hash = hash * 5 + id;
        hash = hash * 7 + (int) id;

        char[] letters = name.toCharArray();
        int a = 0;
        for (char i: letters) a = i + (31 * a);

        hash = hash * 13 + a;
        return hash;
    }
}