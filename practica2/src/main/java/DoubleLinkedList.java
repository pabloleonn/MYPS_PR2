
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

    
}