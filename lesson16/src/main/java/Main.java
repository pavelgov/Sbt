import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 06.10.2017.
 */
public class Main {
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < 100000  ; i++) {
            map.put(i,"value "+i);
        }
    }
}
