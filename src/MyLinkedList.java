public class MyLinkedList <T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Здорова");
        list.add("Zdorova");
        list.add("Zdorova");
        list.add("Zdorova");
        list.add("Zdorova");
        list.add("Zdorova");
        list.add("Zdorova");
        System.out.println(list.size());
        System.out.println(list.get(1));
        list.remove(5);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }

    public void add (T value) {
        Node<T> last = lastNode;
        Node<T> newNode = new Node<T>(value, last, firstNode);
        lastNode = newNode;
        if (last == null) {
            firstNode = newNode;
        }
        else {
            last.setNext(newNode);
        }
        size++;
    }

    public void remove(int index) {
        Node<T> removing = firstNode;
        for (int i = 0; i < index; i++) {
            removing = removing.getNext();
        }
        if (index == 0) {
            firstNode = removing.getNext();
        } else {
            removing.getPrev().getNext();
        }
        size--;
    }

    public void clear () {
        Node<T> first = firstNode;
        for (int i = 0; i < size; i++) {
            first.setItem(null);
            first.setNext(null);
            first.setPrev(null);
        }
        size = 0;
    }

    public Integer size () {
        return size;
    }

    public T get (int index) {
        Node<T> target = firstNode;
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target.getItem();
    }

}
