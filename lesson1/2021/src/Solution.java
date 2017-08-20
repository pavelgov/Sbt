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

        int[] mas = new int[n];// sozdali masiv
        for (int i = 0; i < n; i++) {
            mas[i] = Integer.parseInt(st.nextToken()); //zapolnayem masiv
        }

        razdelit(mas, max(mas));
        razdelit(mas, max(mas));

        for (int x : mas) {
            System.out.print(x + " ");
        }
    }

    public static int max(int[] mas) {
        int result = 0;

        for (int i = 0; i < mas.length; i++) {
            if (result < mas[i]) result = mas[i];
        }
        return result;
    }

    public static int[] razdelit(int[] mas, int max) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == max) {
                if ((max % 2) == 0) mas[i] = mas[i] / 2;
                else mas[i] = (mas[i] - 1) / 2;
            }
        }
        return mas;
    }
}
