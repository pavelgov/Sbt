import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by User on 20.08.2017.
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
            int max = mas[0];
            int count = 0;
            int tmp = 0;
            int tcount = 0;


            for (int i = 0; i < mas.length; i++) {
                if (mas[i] == max) { //esli max
                    count++;
                } else if (mas[i] != max) {  // esli tmp
                    tmp = mas[i];
                    tcount++;
                } else if (mas[i] != max && mas[i] != tmp) {  // esli ni to ni to
                    if (tcount > count) {         //esli 2 schetchik > 1
                        count = tcount;           // to 1 == 2 schetchik
                        tcount = 0;               // 2 schetchik obnulayem
                    } else tcount = 0;
                }
            }

            System.out.println(count);
        }
    }
}
