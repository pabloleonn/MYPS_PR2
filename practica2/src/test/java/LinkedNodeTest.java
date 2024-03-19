import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedNodeTest {
@Test
    @DisplayName("Tras crear un linkedNode, el elemento creado es el mismo que el almacenado")
    public void getItem_beforeInitialize_return() {
        int item = 1;
        LinkedNode<Integer> node = new LinkedNode<Integer>(item,null,null);
        assertEquals(item, node.getItem());
    }
}