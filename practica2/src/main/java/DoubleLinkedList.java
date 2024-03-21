import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        if(this.size == 0) {
            this.first = new LinkedNode<T>(value, null, null);
            this.last = this.first;
        } else {
            LinkedNode<T> newNode = new LinkedNode<T>(value, null, first);
            LinkedNode<T> oldFirst = first;
            oldFirst.setPrevious(newNode);
            this.first = newNode;
            this.first.setNext(oldFirst);
        }   
        this.size++;
    }

    @Override
    public void append(T value) {
        if(this.size == 0) {
            this.last = new LinkedNode<T>(value, null, null);
            this.first = this.last;
        } else {
            LinkedNode<T> newNode = new LinkedNode<T>(value, last, null);
            LinkedNode<T> oldLast = last;
            oldLast.setNext(newNode);
            this.last = newNode;
            this.last.setPrevious(oldLast);
        }
        this.size++;
    }

    @Override
    public void deleteFirst() {
        if(this.size<1){
           throw new DoubleLinkedQueueException("La lista está vacía");
        }else if(this.size()==1){
            this.first = null;
            this.last = null;
        }else if(this.size()==2){
            this.first = this.last;
        }else{
            LinkedNode<T> aux = first.getNext();
            this.first = aux;
        }
        this.size--;
    }

    @Override
    public void deleteLast() {
        if(this.size<1){
            throw new DoubleLinkedQueueException("La lista está vacía");
        }else if(this.size()==1){
            this.last = null;
            this.first = null;
        }else if(this.size()==2){
            this.last = this.first;
        }else{
            LinkedNode<T> aux = last.getPrevious();
            this.last = null;
            this.last = aux;
        }
        this.size--;
    }

    @Override
    public T first() {
        return this.first.getItem();
    }

    @Override
    public T last() {
        return this.last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        LinkedNode<T> current = null;
        if(index < 0 || index >= this.size) {
            throw new DoubleLinkedQueueException("Index out of bounds");
        } else {
            int i = 0;
            current = this.first;
            while(i < index) {
                current = current.getNext();
                i++;
            }
        }
        return current.getItem();
    }

    @Override
    public boolean contains(T value) {
        LinkedNode<T> current = this.first;
        boolean esta = false;
        while(current != null && !esta) {
            if(current.getItem().equals(value)) {
                esta = true;
            }
            current = current.getNext();
        }
        return esta;
    }

    @Override
    public void remove(T value) {
        if(!this.contains(value)) {
            throw new DoubleLinkedQueueException("No esta");
        } else {
            LinkedNode<T> current = this.first;
            LinkedNode<T> previous = null;
            LinkedNode<T> next = current.getNext();
            while(current != null) {
                if(current.getItem() != value) {
                    previous = current;
                    current = next;
                    next = current.getNext();
                } else {
                    if(current == this.first) {
                        this.deleteFirst();
                    } else if(current == this.last) {
                        this.deleteLast();
                    } else {
                        previous.setNext(next);
                        next.setPrevious(previous);
                        this.size--;
                    }
                    }
                }
            }
        }
    

    @Override
    public void sort(Comparator<? super T> comparator){
        if(first!=null){
            quickSortRecursive(first, last, comparator);
        }
    }

    private void quickSortRecursive(LinkedNode<T> low, LinkedNode<T> high, Comparator<? super T> comparator) {
        if (low != null && high != null && low != high && high.getNext() != low) {
            LinkedNode<T> pi = partition(low, high, comparator);
            quickSortRecursive(low, pi.getPrevious(), comparator);
            quickSortRecursive(pi.getNext(), high, comparator);
        }
    }

    private LinkedNode<T> partition(LinkedNode<T> low, LinkedNode<T> high, Comparator<? super T> comparator) {
        T pivot = high.getItem();
        LinkedNode<T> i = low.getPrevious();
        for (LinkedNode<T> j = low; j != high; j = j.getNext()) {
            if (comparator.compare(j.getItem(), pivot) < 0) {
                i = (i == null) ? low : i.getNext();
                swap(i, j);
            }
        }
        i = (i == null) ? low : i.getNext();
        swap(i, high);
        return i;
    }

    private void swap(LinkedNode<T> node1, LinkedNode<T> node2) {
        T temp = node1.getItem();
        node1.setItem(node2.getItem());
        node2.setItem(temp);
    }
}