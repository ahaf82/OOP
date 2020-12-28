package ea4.aufgabe2;

import java.lang.Comparable;

public class MaximumContainer<T extends Comparable> {
    private T storedElement;

    public MaximumContainer() { }

    public void store (T element) {
        if (storedElement == null || element.compareTo(storedElement) > 0) {
            storedElement = element;
        }
    }

    public T get(){
        return storedElement;
    }
}

