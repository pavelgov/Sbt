import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by User on 19.08.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine()); // 1  stroka
        StringTokenizer st = new StringTokenizer(buf.readLine()); // 2 stroka
        if (n > 0 && n <= 10000) {
            int[] mas = new int[n];// sozdali masiv

            for (int i = 0; i < n; i++) {
                mas[i] = Integer.parseInt(st.nextToken()); //zapolnayem masiv
            }
            int min = mas[0];
            int index = 1;
            for (int i = 0; i < mas.length; i++) {
                if (mas[i] < min) {
                    min = mas[i];
                    index = i + 1;
                }
            }
            System.out.println(index);
        }
    }
}
