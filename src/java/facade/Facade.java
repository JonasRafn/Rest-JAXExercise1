package facade;

import java.util.HashMap;
import java.util.Map;

public class Facade {

    private static Map<Integer, String> qoutes = new HashMap();
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
