import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedNodeTest {
    @Test
    @DisplayName("Tras crear un linkedNode, el elemento creado es el mismo que el almacenado")
    public void getItem_beforeInitialize_returnTrue() {
        int item = 1;
        LinkedNode<Integer> node = new LinkedNode<Integer>(item,null,null);
        assertEquals(item, node.getItem());
    }

    @Test
    @DisplayName("Creo un linkNode con un valor y luego lo actualizo. Devuelve el valor actualizado. ")
    public void setItem_setItemCorrectly_returnTrue() {
        int item = 1;
        LinkedNode<Integer> node = new LinkedNode<Integer>(item,null,null);
        int newItem = 2;
        node.setItem(newItem);
        assertEquals(newItem, node.getItem());
    }

    @Test
    @DisplayName("Creo un linkNode con un valor y luego lo actualizo.No devuelve el primer valor.")
    public void setItem_setItemCorrectly_returnFalse() {
        int item = 1;
        LinkedNode<Integer> node = new LinkedNode<Integer>(item,null,null);
        int newItem = 2;
        node.setItem(newItem);
        assertNotEquals(item, node.getItem());
    }
    @Test
    @DisplayName("Previous de un nodo que no está en una lista es nulo.")
    public void getPrevious_aloneNode_returnNull() {
        int item = 1;
        LinkedNode<Integer> node = new LinkedNode<Integer>(item,null,null);
        assertNull(node.getPrevious());
    }

    @Test
    @DisplayName("Si creo un nodo y le añado un previous, la funcion lo devuelve correctamente.")
    public void getPrevious_twoNodes_returnTrue() {
        int item = 1;
        LinkedNode<Integer> previous = new LinkedNode<Integer>(item,null,null);
        LinkedNode<Integer> node = new LinkedNode<Integer>(item,previous,null);
        node.getPrevious();
        assertEquals(node.getPrevious(),previous);
    }

    @Test
    @DisplayName("Cuando seteo un previous lo almacena correctamente")
    public void setPrevious_returnTrue() {
        int item = 1;
        LinkedNode<Integer> node = new LinkedNode<Integer>(item,null,null);
        LinkedNode<Integer> previous = new LinkedNode<Integer>(item+1, null, null);
        node.setPrevious(previous);
        assertEquals(previous,node.getPrevious());
    }

    @Test
    @DisplayName("Si creo un nodo y le añado un next, la funcion lo devuelve correctamente.")
    public void getNext_twoNodes_returnTrue() {
        int item = 1;
        LinkedNode<Integer> next = new LinkedNode<Integer>(item,null,null);
        LinkedNode<Integer> node = new LinkedNode<Integer>(item,null,next);
        node.getPrevious();
        assertEquals(node.getNext(),next);
    }

}