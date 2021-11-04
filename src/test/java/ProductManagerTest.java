import domain.Book;
import domain.Smartphone;
import domain.Product;
import manager.ProductManager;
import repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private final ProductManager manager = new ProductManager((new Repository()));
    private final Product first = new Product(124, " toy", 350);
    private final Book second = new Book(132, "Math for kids", 600, "Иванов");
    private final Smartphone third = new Smartphone(135, "S20", 70000, "samsung");
    private final Book fourth = new Book(136, "S20", 230, "Петров");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void shouldSearchByName() {
        Product[] expected = {first};
        assertArrayEquals(expected, manager.searchBy("toy"));

    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = {second};
        assertArrayEquals(expected, manager.searchBy("Иванов"));
    }

    @Test
    public void shouldSearchByManufacturer() {
        Product[] expected = {third};
        assertArrayEquals(expected, manager.searchBy("samsung"));
    }

    @Test
    public void shouldSearchByUnsuitableProduct() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("nokia"));
    }

    @Test
    public void shouldSearchSameNameProduct() {
        Product[] expected = {third, fourth};
        assertArrayEquals(expected, manager.searchBy("S20"));

    }
}