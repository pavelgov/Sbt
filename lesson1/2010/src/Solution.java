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
        StringTokenizer st = new StringTokenizer(buf.readLine());

        gcd(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
    }

    public static int gcd(int a, int b, int count) {
        if (b == 0) {
            System.out.println(count + " " + a);
            return (a);
        }

        if (a > b) {
            a = a - b;

        } else {
            b = b - a;
        }
        count++;
        return gcd(a, b, count);
    }

}
