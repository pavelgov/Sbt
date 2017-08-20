import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by User on 19.08.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine()); // 1  stroka

        String[] mas = new String[n]; // sozdali masiv
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mas[i] = buf.readLine(); //zapolnayem masiv
        }

        for (String slovo : mas) {  //bezim po spisku
            if (!strange(slovo)) list.add(slovo); // esli ne strannoe to dobavlayem v list
        }

        for (String element : list) {  //vyvod na ekran
            System.out.println(element);
        }

    }

    public static boolean strange(String s) {
        String[] word = s.split("");
        int count = 0;
        for (String x : word) {

            if ((x.equals("e")) || (x.equals("y")) || (x.equals("u")) ||
                    (x.equals("i")) || (x.equals("o")) || (x.equals("a")))
                count++;
            else count = 0;
            if (count >= 3) break;
        }

        if (count >= 3) return true;
        else return false;

    }


}

