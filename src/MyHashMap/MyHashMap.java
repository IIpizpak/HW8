package MyHashMap;

import static java.util.Objects.hash;


public class MyHashMap<K, V> implements MyHashMapMethods {

    Node[] keyTexts = new Node[16];
    int size = 0;

    public static void main(String[] args) {

        MyHashMap<Integer, String> hashMap = new MyHashMap<Integer, String>();

        hashMap.put(1, "one");
        hashMap.put(2, "two");

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(3));
        hashMap.size();
        hashMap.clear();
        System.out.println(hashMap.get(11));
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    public V putVal(int hash, K key, V value) {
        size++;
        int i = 0;
        i = hash % keyTexts.length;
        keyTexts[i] = new Node(hash, key, value, null);
        return null;
    }

    public V get(K key) {
        V tempValue = null;
        for (int i = 0; i < keyTexts.length; i++) {
            if (keyTexts[i] != null) {
                if (keyTexts[i].getKey().hashCode() == key.hashCode()) {
                    tempValue = (V) keyTexts[i].getValue();
                }
            }
        }
        return tempValue;
    }

    @Override
    public void remove(Object key) {
        for (int i = 0; i < keyTexts.length; i++) {
            if (keyTexts[i] != null) {
                if (keyTexts[i].getKey().hashCode() == key.hashCode()) {
                    keyTexts[i] = null;
                    size--;
                }
            }
        }
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < keyTexts.length; i++) {
            keyTexts[i] = null;
        }
    }

    @Override
    public void size() {
        System.out.println(size);
    }
}

