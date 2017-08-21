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
        StringTokenizer st = new StringTokenizer(buf.readLine());
        StringTokenizer st1 = new StringTokenizer(buf.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st1.nextToken());
        int b2 = Integer.parseInt(st1.nextToken());

        int x1, x2, y, z;

        if (a1 < b1) {
            x1 = a1;
            y = b1;
        } else {
            x1 = b1;
            y = a1;
        }


        if (a2 < b2) {
            x2 = a2;
            z = b2;
        } else {
            x2 = b2;
            z = a2;
        }

        if (x1 + x2 == y && y == z) System.out.println("YES");
        else
            System.out.println("NO");


    }
}
