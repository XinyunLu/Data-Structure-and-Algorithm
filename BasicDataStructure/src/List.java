public interface List<E> {
    //interface does not contain any fields, only contains method signatures
    public void add(E e);

    public boolean remove(E e);

    public int size();

    public E get(int i);
}

