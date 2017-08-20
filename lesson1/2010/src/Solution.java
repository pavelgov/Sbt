import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by User on 19.08.2017.
 */
public class Solution {
   static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
    }


        public  int nod(int a, int b) {

            if (b == 0) {
                System.out.println(count+" "+ a);
                return a;
            }
            else {
                int x = a % b;
                count++;
                return nod(b, x);
            }
        }




}
