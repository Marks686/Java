/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-05
 * Time: 20:38
 */
public class Student {
    private String name;
    private String gender;
    private int age;
    private double score;
    private static String classRoom;
    //实例代码块
    {
        this.name = "bit";
        this.age = 12;
        this.gender = "man";
        System.out.println("I am instance init()!");
    }
    // 静态代码块
    static {
        classRoom = "bit306";
        System.out.println("I am static init()!");
    }
    public Student(){
        System.out.println("I am Student init()!");
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
    }

}
