import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 20.08.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        if (n < 7) System.out.println("preschool child");
        else if (n >= 7 && n <= 17) System.out.println("schoolchild " + (n - 6));
        else if (n >= 18 && n <= 22) System.out.println("student " + (n - 17));
        else if (n > 22) System.out.println("specialist");
    }
}
