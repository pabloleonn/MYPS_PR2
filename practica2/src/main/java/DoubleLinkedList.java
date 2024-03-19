
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

            this.first = newNode;
            this.first.setNext(oldFirst);
        }   
        this.size++;
    }

    @Override
    public void append(T value) {
        if(this.size == 0) {
            this.first = new LinkedNode<T>(value, null, null);
        } else {
            LinkedNode<T> newNode = new LinkedNode<T>(value, last, null);
            LinkedNode<T> oldLast = last;

            this.last = newNode;
            this.last.setPrevious(oldLast);
        }
        this.size++;
    }

    @Override
    public void deleteFirst() {
        if(this.size()<2){
            this.first = null;
        }else if(this.size()==2){
            this.first = this.last;
        }
        LinkedNode<T> aux = first.getNext();
        this.first = null;
        this.first = aux;
        this.size--;
    }

    @Override
    public void deleteLast() {
        if(this.size()<2){
            this.last = null;
        }else if(this.size()==2){
            this.last = this.first;
        }
        LinkedNode<T> aux = last.getPrevious();
        this.last = null;
        this.last = aux;
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
}