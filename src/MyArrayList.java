public class MyArrayList <T>{

    private T[] array;

    public T[] add(T value) {

        if (array == null) {
            T[] arrayAdd = (T[]) new Object[1];
            arrayAdd[0] = value;
            return this.array = arrayAdd;
        } else {
            T[] arrayAdd = (T[]) new Object[array.length + 1];
            System.arraycopy(array, 0, arrayAdd, 0, array.length);
            arrayAdd[arrayAdd.length - 1] = value;
            this.array = arrayAdd;
        }
        return array;
    }

    public void remove(int index) {
        try {
            T[] tempArray = (T[]) new Object[array.length - 1];
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != array[index]) {
                    tempArray[j] = array[i];
                    j++;
                }
            }
            array = tempArray;
        } catch (Exception e) {
            System.out.println("Array is empty");
        }
    }

    public T[] clear() {
        T[] tempArray = (T[]) new Object[0];
        return array = tempArray;
    }

    public int size() {
        if (array == null) return 0;
        return array.length;
    }

    public T get(int index) {
        if (array == null) return (T) "Exception - Array is empty";
        return array[index];
        }
}

class MyArrayListTester {

    public static void main(String[] args) {
        MyArrayList<String> stringArray = new MyArrayList<>();
//        stringArray.add("Привет");
//        stringArray.add("Привет2");
//        stringArray.add("Привет3");
        System.out.println(stringArray.size());
        System.out.println(stringArray.get(0));
        stringArray.clear();
        System.out.println(stringArray.size());
    }

}