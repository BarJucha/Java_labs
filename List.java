import java.util.Collection;

public class List <E>{
    private elementList<E> head;
    private int size;

    public List(){
        head = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean contains(Object o) {
        if (!(o instanceof elementList<?>)){
            throw new ClassCastException();
        }
        elementList<E> e = head;
        if(o==null){
            throw new NullPointerException();
        }
        while (e != null) {
            if (o==null ? e==null : o.equals(e)) {
                return true;
            }
            e = e.next;
        }
        return false;
    }
    public Iterator<E> iterator(){
        return new Iterator<>(head);
    }
    public Object[] toArray() {
        Object[] array = new Object[size];
        elementList<E> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }
    public boolean add(E e) {
        if(e==null){
            throw new NullPointerException();
        }
        elementList<E> newElement = new elementList<>();
        newElement.data = e;
        if (head == null) {
            head = newElement;
        } else {
            elementList<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newElement;
        }
        size++;
        return true;
    }
    public boolean remove(Object o) {
        if (!(o instanceof elementList<?>)){
            throw new ClassCastException();
        }
        if(o==null){
            throw new NullPointerException();
        }
        if (head == null) {
            return false;
        }
        if (o==null ? head==null : o.equals(head)) {
            head = head.next;
            size--;
            return true;
        }
        elementList<E> current = head;
        while (current.next != null && !(o==null ? current==null : o.equals(current))) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!(item instanceof elementList<?>)){
                throw new ClassCastException();
            }
            if (item == null) {
                throw new NullPointerException();
            } else {
                boolean found = false;
                elementList<E> current = head;
                while (current != null) {
                    if (item.equals(current.data)) {
                        found = true;
                        break;
                    }
                    current = current.next;
                }
                if (!found) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Specified collection is null");
        }

        boolean modified = false;
        Iterator<? extends E> iterator = (Iterator<? extends E>) c.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (element == null) {
                throw new NullPointerException();
            } else if ((!(element instanceof elementList<?>))) {
                throw new ClassCastException();
            } else {
                add(element);
                modified = true;
            }
        }
        return modified;
    }
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        elementList<E> newElement = new elementList<>();
        newElement.data = element;

        if (index == 0) {
            // Insert at the beginning
            newElement.next = head;
            head = newElement;
        } else {
            // Insert at the specified index
            elementList<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            newElement.next = current.next;
            current.next = newElement;
        }

        size++;
    }
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        elementList<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E previousElement = current.data;
        current.data = element;
        return previousElement;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        elementList<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }
    public int hashCode() {
        int hashCode = 1;
        elementList<E> current = head;
        while (current != null) {
            hashCode = 31 * hashCode + (current.data == null ? 0 : current.data.hashCode());
            current = current.next;
        }
        return hashCode;
    }
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        elementList<E> removedElement;
        if (index == 0) {
            // Removing the first element
            removedElement = head;
            head = head.next;
        } else {
            // Removing from a non-first position
            elementList<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            removedElement = current.next;
            current.next = current.next.next;
        }

        size--;
        return removedElement.data;
    }
    public int indexOf(Object o) {
        if (o == null) {
            elementList<E> current = head;
            for (int i = 0; i < size; i++) {
                if (current.data == null) {
                    return i;
                }
                current = current.next;
            }
        } else {
            elementList<E> current = head;
            for (int i = 0; i < size; i++) {
                if (o.equals(current.data)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }
    public int lastIndexOf(Object o) {
        if (o == null) {
            elementList<E> current = head;
            int lastIndex = -1;
            for (int i = 0; i < size; i++) {
                if (current.data == null) {
                    lastIndex = i;
                }
                current = current.next;
            }
            return lastIndex;
        } else {
            elementList<E> current = head;
            int lastIndex = -1;
            for (int i = 0; i < size; i++) {
                if (o.equals(current.data)) {
                    lastIndex = i;
                }
                current = current.next;
            }
            return lastIndex;
        }
    }
    public void clear() {
        head = null;
        size = 0;
    }
}
