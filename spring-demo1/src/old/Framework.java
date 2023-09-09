package old;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-09
 * Time: 14:53
 */
public class Framework {
    private Bottom bottom;
    public Framework(int size){
        bottom = new Bottom(size);
    }
    public void init(){
        System.out.println("执行了 Framework 的init方法");
        // 依赖底盘
        bottom.init();
    }
}
