import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
    
    @Test
    @DisplayName("Al añadir al principio si es el primer elemento también es el último")
    public void prepend_ifFirstElementIsAlsoLast_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.prepend(1);
        assertEquals(list.first(), list.last());
    }

    @Test
    @DisplayName("Al añadir al principio no es igual al último elemento")
    public void prepend_ifNotFirstElementIsNotLast_returnFalse() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.prepend(1);
        list.prepend(2);
        assertFalse(list.first().equals(list.last()));
    }

    @Test
    @DisplayName("Al añadir al final si es el primer elemento también es el último")
    public void append_ifFirstElementIsAlsoLast_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        assertEquals(list.first(), list.last());
    }   

    @Test
    @DisplayName("Al añadir al final no es igual al primer elemento si había más")
    public void append_ifNotFirstElementIsNotLast_returnFalse() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.append(2);
        assertFalse(list.first().equals(list.last()));
    }

    @Test
    @DisplayName("Si intento eliminar un elemento de una lista vacía lanza excepción")
    public void deleteFirst_ifEmptyList_throwException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertThrows(DoubleLinkedQueueException.class, () -> list.deleteFirst());
    }

    @Test
    @DisplayName("Si elimino el primer elemento de una lista con un solo elemento, la lista queda vacía")
    public void deleteFirst_ifOneElementInList_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.deleteFirst();
        assertTrue(list.size() == 0);
    }

    @Test
    @DisplayName("Si elimino el primer elemento de una lista con dos elementos, el primero será igual al ultimo")
    public void deleteFirst_ifDeleteFirstElementInListWithTwoElements_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.deleteFirst();
        assertEquals(list.first(), list.last());
    }

    @Test
    @DisplayName("Si elimino el primer elemento de una lista con tres elementos, el primero será el que era segundo")
    public void deleteFirst_ifDeleteFirstElementInListWithThreeElements_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.deleteFirst();
        assertEquals(list.first(), 2);
    }

    @Test
    @DisplayName("Si intento eliminar el último elemento de una lista vacía lanza excepción")
    public void deleteLast_ifEmptyList_throwException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertThrows(DoubleLinkedQueueException.class, () -> list.deleteLast());
    }

    @Test
    @DisplayName("Si elimino el último elemento de una lista con un solo elemento, la lista queda vacía")
    public void deleteLast_ifOneElementInList_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.deleteLast();
        assertTrue(list.size() == 0);
    }

    @Test
    @DisplayName("Si elimino el último elemento de una lista con dos elementos, el primero será igual al ultimo")
    public void deleteLast_ifDeleteFirstElementInListWithTwoElements_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.deleteLast();
        assertEquals(list.first(), list.last());
    }

    @Test
    @DisplayName("Si elimino el último elemento de una lista con tres elementos, el último será el que era penúltimo")
    public void deleteLast_ifDeleteFirstElementInListWithThreeElements_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);
        list.deleteLast();
        assertEquals(list.last(), 2);
    }

    @Test
    @DisplayName("Si creo una lista con un elemento el first es el elemento")
    public void first_ifOneElementInList_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        assertEquals(list.first(), 1);
    }

    @Test
    @DisplayName("Si creo una lista con un elemento el last es el elemento")
    public void last_ifOneElementInList_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        assertEquals(list.last(), 1);
    }

    @Test
    @DisplayName("Si creo una lista con dos elementos el tamaño es dos")
    public void size_ifTwoElementsInList_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.append(2);
        assertEquals(list.size(), 2);
    }

    @Test
    @DisplayName("Si creo una lista e intento obtener un elemento en posicion negativa retorna excepción")
    public void get_ifNegativeIndex_throwException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertThrows(DoubleLinkedQueueException.class, () -> list.get(-1));
    }

    @Test
    @DisplayName("Si creo una lista e intento obtener un elemento en una posición mayor al tamaño retorna excepción")
    public void get_ifIndexGreaterThanSize_throwException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertThrows(DoubleLinkedQueueException.class, () -> list.get(1));
    }

    @Test
    @DisplayName("Si creo una lista con dos elementos y obtengo el primero, el primero es el primero")
    public void get_ifTwoElementInListGetFirst_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.append(2);
        assertEquals(list.get(0), 1);
    }

    @Test
    @DisplayName("Si creo una lista con dos elementos y consulto si está uno diferente retorna falso")
    public void contains_ifOneElementInListWithDifferentElement_returnFalse() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.append(2);
        assertFalse(list.contains(3));
    }

    @Test
    @DisplayName("Si creo una lista con dos elementos y consulto si está retorna verdadero")
    public void contains_ifOneElementInListAndContains_returnTrue() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.append(1);
        list.append(2);
        assertTrue(list.contains(2));
    }
}

