public class ArrayIntList {
    private static final int DEFAULT_CAPACITY = 5;
    private int[] elementData;
    private int size;

    public ArrayIntList() {
        elementData = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(int value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    public void remove(int index) {
        //  0  1  2  3  4  5
        // [3, 1, 4, 1, 5, 9]
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    public void ensureCapacity(int capacity) {
        if (capacity >= elementData.length) {
            int[] newArray = new int[size * 2 + 1];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];
            }
            elementData = newArray;
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < size - 1; i++) {
            result += elementData[i] + ", ";
        }
        result += elementData[size - 1] + "]";
        return result;
    }
}
