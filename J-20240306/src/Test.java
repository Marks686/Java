/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2024-03-06
 * Time: 16:43
 */
public class Test {
    public static void main(String[] args) {
//        String s1 = "hello bit";
//        System.out.println(s1);
//
//        String s2 = new String("hello bit");
//        System.out.println(s2);
//
//        char[] array = {'h','e','l','l','o','b','i','t'};
//        String s3 = new String(array);
//        System.out.println(s3);

//        String s1 = new String("abcde");
//        String s2 = new String("ac");
//        String s3 = new String("abc");
//        String s4 = new String("abcdef");
//        System.out.println(s1.compareTo(s2)); // 不同输出字符差值-1
//        System.out.println(s1.compareTo(s3)); // 相同输出 0
//        System.out.println(s1.compareTo(s4)); // 前k个字符完全相同，输出长度差值 -3

//        String s1 = String.valueOf(1234);
//        String s2 = String.valueOf(12.34);
//        System.out.println(s1);
//        System.out.println(s2);
//
//        String str = "helloworld" ;
//        System.out.println(str.replaceAll("l", "_"));
//        System.out.println(str.replaceFirst("l", "_"));
//        String str = "hello world hello bit" ;
//        String[] result = str.split(" ") ; // 按照空格拆分
//        for(String s: result) {
//            System.out.println(s);
//        }

//        String str = "hello world hello bit" ;
//        String[] result = str.split(" ",3) ;
//        for(String s: result) {
//            System.out.println(s);
//        }

//        String str = "192.168.1.1" ;
//        String[] result = str.split("\\.") ;
//        for(String s: result) {
//            System.out.println(s);
//        }

//        String str = "name=zhangsan&age=18" ;
//        String[] result = str.split("&") ;
//        System.out.println(result.length);
//        for (int i = 0; i < result.length; i++) {
//            String[] temp = result[i].split("=") ;
//            System.out.println(temp[0]+" = "+temp[1]);
//        }


        String str = "helloworld" ;
        System.out.println(str.substring(5));
        System.out.println(str.substring(0, 5));

    }
}
