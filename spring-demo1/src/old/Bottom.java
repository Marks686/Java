package old;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-09
 * Time: 14:58
 */
public class Bottom {
    private Tire tire;
    public Bottom(int size){
        tire = new Tire(size);
    }
    public void init(){
        System.out.println("执行了 Bottom 的init方法");
        // 依赖轮胎
        tire.init();
    }
}
