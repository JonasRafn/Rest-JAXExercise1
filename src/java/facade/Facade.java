package facade;

import java.util.HashMap;
import java.util.Map;

public class Facade {

    private static Map<Integer, String> qoutes = new HashMap() {{
        put(1,"Friends are kisses blown to us by angels");
        put(2, "Do not take life too seriously. You will never get out of it alive");
        put(3, "Behind every great man, is a woman rolling her eyes");
    }
    };
    private static int count = 1;

    public static void addQoute(int index, String qoute) {
        qoutes.put(index, qoute);
    }

    public static String getQoute(int index) {
        return qoutes.get(index);
    }

    public static void createQoute(String qoute) {
        qoutes.put(count, qoute);
        count++;
    }

    public static int getMapSize() {
        return qoutes.size();
    }

    public static void deleteQoute(int index) {
        qoutes.remove(index);
    }

    public static void editQoute(int index, String qoute) {
        if (qoutes.containsKey(index)) {
            qoutes.put(index, qoute);
        }
    }
}
