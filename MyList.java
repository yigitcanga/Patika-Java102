public class MyList<T> {

    private int capacity;
    private int index = 0;
    T[] arr;

    public MyList() {
        this.capacity = 10;
        this.arr = (T[]) new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }

    }


    public int size() {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) size++;
        }

        return size;

    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {

        if (this.index < this.capacity) {
            arr[this.index] = data;
            this.index++;
        } else {
            this.capacity *= 2;
            T[] newArr = (T[]) new Object[arr.length + this.capacity];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[this.index] = data;
            this.index++;
            this.arr = (T[]) new Object[this.capacity];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = newArr[i];
            }
        }
    }

    public T get(int index) {
        if (index < 0 || index >= arr.length) return null;
        else return this.arr[index];
    }

    public T set(int index, T data) {
        if (index < 0 || index >= arr.length) return null;
        else {
            this.arr[index] = data;
            return this.arr[index];
        }
    }

    public T remove(int index) {
        if (index < 0 || index >= arr.length) return null;
        else {
            T deleteIndexValue = this.arr[index];
            for (int i = index; i < this.index; i++) {
                this.arr[i] = this.arr[i + 1];
            }
            this.arr[size()] = null;
            this.index--;
            return deleteIndexValue;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (T arr : this.arr) {
            if (arr != null) {
                stringBuilder.append(arr.toString() + ",");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < this.arr.length; i++) {
            if (data == this.arr[i]) {
                return i;
            }

        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = this.arr.length-1; i >= 0; i--) {
            if (data == this.arr[i]) {
                return i;
            }

        }
        return -1;
    }

    public boolean isEmpty()
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) return false;
        }

        return true;
    }

    public T[] toArray(){
        return this.arr;
    }

    public void clear()
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
    }

    public MyList<T> subList(int start,int finish){
        MyList<T> newMyList = new MyList<>();
        for(int i = start; i<=finish; i++){
            newMyList.add(this.arr[i]);
        }
        return newMyList;
    }

    public boolean contains(T data)
    {
        for (int i = 0; i < arr.length; i++) {
            if (data == this.arr[i]) {
                return true;
            }
        }
        return false;
    }

}