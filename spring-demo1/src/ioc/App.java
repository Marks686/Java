package ioc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-09-09
 * Time: 15:52
 */
//public class App {
//    public static void main(String[] args) {
//        Tire tire = new Tire(15);
//        Bottom bottom = new Bottom();
//        Framework framework = new Framework(bottom);
//        Car car = new Car(framework);
//        car.init();
//    }
//}

public class App {
    public static void main(String[] args) {
        Tire tire = new Tire(30);
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.init();
    }
}
