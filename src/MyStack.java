import java.util.Arrays;

public class MyStack<T> {

    private T[] stack;

    public T[] push(T value) {
        T[] stackTemp;
        if (stack == null) {
            stackTemp = (T[]) new Object[1];
            stackTemp[0] = value;
        } else {
            stackTemp = (T[]) new Object[stack.length + 1];
            System.arraycopy(stack, 0, stackTemp, 0, stack.length);
            stackTemp[stackTemp.length - 1] = value;
        }
        this.stack = stackTemp;
        return stack;
    }

    public T[] remove(int index) {
        T[] stackTemp = (T[]) new Object[stack.length - 1];
        int j = 0;
        for (int i = 0; i < stack.length; i++) {
            if (i != index) {
                stackTemp[j] = stack[i];
                j++;
            }
        }
        this.stack = stackTemp;
        return stack;
    }

    public T[] clear() {
        T[] tempStack = (T[]) new Object[0];
        return this.stack = tempStack;
    }

    public Integer size() {
        return stack.length;
    }

    public T peek() {
        return stack[stack.length - 1];
    }

    public T pop() {
        T[] stackTemp = (T[]) new Object[stack.length - 1];
        T temp = stack[stack.length - 1];
        System.arraycopy(stack, 0, stackTemp, 0, stack.length - 1);
        this.stack = stackTemp;
        return temp;
    }

    public void print() {
        System.out.println(Arrays.toString(stack));
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.print();
        System.out.println("pop " + stack.pop());
        stack.print();
        System.out.println(stack.size());
    }

}
