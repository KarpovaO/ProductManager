
import domain.Product;
import domain.Book;
import domain.Smartphone;

public class ProductManager {
    private final Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        Product[] products = repo.getAll();
        for (Product product : products) {
            if (matches(product, text)) {
                var tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;

    }

    public boolean matches(Product product, String search) {
        if(product.getName().contains(search)){
            return true;
        }


        if (product instanceof Book) {
            var book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
        }
        if(product instanceof Smartphone){
           var smartphone = (Smartphone) product;
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
        }
        return false;
    }
}





