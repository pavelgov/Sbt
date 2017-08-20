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
        int[] mas = new int[n]; // sozdali masiv
        StringTokenizer st = new StringTokenizer(buf.readLine()); // 2 stroka

        for (int i = 0; i < n; i++) {
            mas[i] = Integer.parseInt(st.nextToken()); //zapolnayem masiv
            if (i % 2 != 0 ) mas[i] *= -1;
        }
        int summa=0;
        for (int x : mas) {
            summa += x;
        }
        System.out.print(summa);

    }
}
