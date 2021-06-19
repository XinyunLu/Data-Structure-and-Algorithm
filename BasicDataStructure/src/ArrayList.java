public class ArrayList<E> implements List<E> {
    E[] items;
    int size;
    public ArrayList (int cap) {
        items = (E[]) new Object[cap];
    }

    @Override
    public void add(E e) {
        items[size ++] = e;
    }

    @Override
    public boolean remove(E e) {
        for(int i = 0; i < size; i++) {
            if(items[i] == e) {
                while(i < size) {
                    items[i] = items[i + 1];
                    i++;
                }
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public E get(int i) {
        return items[i];
    }

    @Override
    public int size() {
        return size;
    }


}
