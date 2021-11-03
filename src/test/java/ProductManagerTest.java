import domain.Book;
import domain.Smartphone;
import domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductManager manager = new ProductManager((new Repository()));


    private Product first = new Product(124, " toy", 350);
    private Book second = new Book(132,"Math for kids",600, "Иванов");
    private Smartphone third = new Smartphone(135,"S20",70000,"samsung");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldSearchByName() {
        Product[] expected = {first};
        assertArrayEquals(expected,manager.searchBy("toy"));

    }

    @Test
    void shouldSearchByAuthor() {
        Product[] expected = {second};
        assertArrayEquals(expected,manager.searchBy("Иванов"));
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = {third};
        assertArrayEquals(expected,manager.searchBy("samsung"));
    }
}