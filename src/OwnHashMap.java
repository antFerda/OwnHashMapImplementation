import java.util.*;

public class OwnHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

    List<LinkedList<Entry<K, V>>> buckets = new ArrayList<LinkedList<Entry<K, V>>>();
    private int size;

    {
        addTwoEmptyBuckets();
    }

    private void addTwoEmptyBuckets() {
        buckets.add(new LinkedList<>());
        buckets.add(new LinkedList<>());
    }


    @Override
    public Object put(Object key, Object value) {
        int hashCode = key.hashCode();
        int index = hashCode% buckets.size();

        buckets.get(index).add(new SimpleEntry(key, value));
        size++;

        if(buckets.size() < size) {
            addTwoEmptyBuckets();
        }
        return value;
    }

    @Override
    public void putAll(Map m) {
        Set<Entry> entries = m.entrySet();

        for(Entry en : entries) {
            put(en.getKey(), en.getValue());
        }

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set = new HashSet<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            bucket.forEach(e -> set.add(e));
        }
        return set;
    }
}
