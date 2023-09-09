package old;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-09
 * Time: 14:59
 */
public class Tire {
    private int size = 20;

    public Tire(int size){
        this.size = size;
    }
    public void init(){
        System.out.println("执行了轮胎初始化方法,size: " + this.size);
    }
}
