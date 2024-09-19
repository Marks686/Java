import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++){
            int n = scanner.nextInt();
            String[] word = new String[n];
            for (int j = 0; j < n; j++){
                word[j] = scanner.next();
            }
            int maxLen = findMaxLen(word);
            System.out.println(maxLen);
        }
        scanner.close();
    }
    public static int findMaxLen(String[] word){
        int maxLen = 0;
        for (char a = 'a'; a <= 'z'; a++){
            for (char b = (char) (a+1); b<= 'z'; b++){
                for (char c = (char) (b + 1); c <= 'z'; c++){
                    int curLen = 0;
                    for (String wordl : word){
                        boolean recgze = true;
                        for (char ch : wordl.toCharArray()){
                            if (ch != a && ch!= b && ch!= c){
                                recgze = false;
                                break;
                            }
                        }
                        if (recgze){
                            curLen += wordl.length();
                        }
                    }
                    maxLen = Math.max(maxLen,curLen);
                }
            }
        }
        return maxLen;
    }
}


