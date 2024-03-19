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

}
