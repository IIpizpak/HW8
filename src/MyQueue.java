import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

public class MyQueue <T> {

    private T[] queue;

    public T[] add(T item) {
        T[] queueTemp;
        if (queue == null) {
            queueTemp = (T[]) new Object[1];
            queueTemp[0] = item;
        }
        else {
            queueTemp = (T[]) new Object[queue.length + 1];
           System.arraycopy(queue, 0, queueTemp, 0, queue.length);
           queueTemp[queueTemp.length - 1] = item;
        }
        this.queue = queueTemp;
        return queue;
    }

    public T[] remove (Integer index) {
        T[] queueTemp = (T[]) new Object[queue.length - 1];
        int j = 0;
        for (int i = 0; i < queue.length; i++) {
            if (i != index) {
                queueTemp[j] = queue[i];
                j++;
            }
        }
        this.queue = queueTemp;
        return queue;
    }

    public T[] clear() {
        T[] queueTemp = (T[]) new Object[0];
        this.queue = queueTemp;
        return queue;
    }

    public int size() {
        return queue.length;
    }

    public T peek () {
        return queue[0];
    }

    public T poll() {
        T temp = queue[0];
        T[] queueTemp = (T[]) new Object[queue.length - 1];
        System.arraycopy(queue, 1, queueTemp, 0, queue.length - 1);
        this.queue = queueTemp;
        return temp;
    }

    public void print() {
        System.out.println(Arrays.toString(queue));
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        System.out.println(Arrays.toString(queue.add("Вася")));
        System.out.println(Arrays.toString(queue.add("Петя")));
        System.out.println(Arrays.toString(queue.remove(0)));
        System.out.println(Arrays.toString(queue.add("Федор")));
        System.out.println(queue.poll());
        queue.print();
        queue.add("Финиш");
        queue.print();
    }

}

