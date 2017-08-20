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
        String[] mas = buf.readLine().split(","); // sozdali masiv slov

        int k = Integer.parseInt(buf.readLine()); // 2  stroka
        if (k > 0 && mas.length > 0 && k <= 1000 && mas.length <=1000) {

            StringBuffer result = new StringBuffer();

           /* for (String slovo : mas) {  //bezim po spisku
                if (slovo.length() >= k) {
                    result.append(slovo);
                    result.append(",");
                }
            }
            if (result.length() > 0)
                System.out.println(result.substring(0, result.length() - 1).toString());*/
            ArrayList<String> list = new ArrayList<>();
            for (String slovo : mas) {  //bezim po spisku
                if (slovo.length() >= k) {
                    list.add(slovo);
                }
            }

            if (!list.isEmpty()){
                for (int i=0; i < list.size(); i++){
                    if (!list.get(i).isEmpty()) {
                        if (i == list.size() - 1) System.out.print(list.get(i));
                        else
                            System.out.print(list.get(i) + ",");
                    }
                }
            }
        }
    }
}
