package ioc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-09
 * Time: 15:40
 */
public class Tire{
    private int size = 20;

    public Tire(int size) {
        this.size = size;
    }

    public void init(){
        System.out.println("轮胎 size: " + this.size);
    }
}
