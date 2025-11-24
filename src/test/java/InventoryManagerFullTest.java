import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
public class InventoryManagerFullTest {
    @Test
    void testAgregarItemNuevo() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Laptop", 5);
        assertEquals(5, manager.getStock("Laptop"));
    }

    @Test
    void testCantidadNegativa() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("Mouse", -1));
    }

    @Test
    void testNombreVacio() {
        InventoryManager manager = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> manager.addItem("", 5));
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    void testNombreMuyCorto() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("A", 5));
    }

    @Test
    void testSumarCantidadExistente() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Laptop", 5);
        manager.addItem("Laptop", 3);
        assertEquals(8, manager.getStock("Laptop"));
    }

    @Test
    void testCantidadMayorMil() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> manager.addItem("Monitor", 1500));
    }

    @Test
    void testExistsMethod() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Laptop", 5);
        assertTrue(manager.exists("Laptop"), "El producto debe existir en el inventario");
        assertFalse(manager.exists("Mouse"), "El producto no debe existir en el inventario");
    }

    @Test
    void testGetInventoryMethod() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Laptop", 5);
        manager.addItem("Mouse", 3);
        Map<String, Integer> inventoryMap = manager.getInventory();
        assertAll("Validar contenido del inventario",
                () -> assertEquals(2, inventoryMap.size(), "Debe haber 2 productos"),
                () -> assertTrue(inventoryMap.containsKey("Laptop"), "Debe contener Laptop"),
                () -> assertEquals(5, inventoryMap.get("Laptop"), "Cantidad de Laptop debe ser 5")
        );
    }

}
