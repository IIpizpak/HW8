package MyHashMap;

import java.util.Objects;

public class Node<K, V> {

    private K key;
    private V value;
    int hash = 0;
    Node<K, V> next;

    public Node(int hash, K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}