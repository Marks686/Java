/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-10-09
 * Time: 12:55
 */
public class NewClass2  {
    public static void main(String[] args) {
        char thief;
        int a,b,c,d,count;
        for (thief = 'A'; thief < 'D'; thief++) {
            a = thief != 'A'?1:0;
            b = thief == 'C'?1:0;
            c = thief == 'D'?1:0;
            d = thief != 'D'?1:0;

            if ((a+b+c+d) == 3){
                System.out.println("小偷是:"+ thief);
            }
        }
    }
}
