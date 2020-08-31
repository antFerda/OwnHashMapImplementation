import java.util.Map;

public class Main {


    public static void main(String[] args) {
        OwnHashMap<String, Integer> hashMap = new OwnHashMap<>();
        hashMap.put("Besh", 1);
        hashMap.put("Borat", 17);
        hashMap.put("Kazakh", 4);


        System.out.println(hashMap.get("Borat"));
        System.out.println(hashMap.get("Kazakh"));
        System.out.println(hashMap.get("Uzbek"));

        hashMap.put("Borat", 22);
        System.out.println(hashMap.get("Borat"));

        System.out.println("Size of buckets: " + hashMap.buckets.size());
    }
}
