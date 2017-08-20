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
        int b = 0;
        int a = n / 36; //futy
        int santim = n % 36; // santimetry

        if (santim % 3 != 2) b = santim / 3;
        else
            b = (santim / 3) + 1;

        System.out.println(a + " " + b);

    }
}
