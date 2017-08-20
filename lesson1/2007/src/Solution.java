import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 19.08.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine()); // 1  stroka

        int kol = 2;
        int count = 0;
        while (true) {
            if (kol <= n) {
                if (n % kol != 0) break;
                kol *= 2;
                count++;
            } else break;
        }

        System.out.println(count);

    }
}

