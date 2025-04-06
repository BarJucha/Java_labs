public class Iterator<E> {
    public elementList<E> current;

    public Iterator(elementList<E> head) {
        current = head;
    }

    public boolean hasNext(){
        return current!=null;
    }
    public E next() {
        if (hasNext()){
            E data = current.data;
            current = current.next;
            return data;
        }
        else throw new IndexOutOfBoundsException();
    }

}
