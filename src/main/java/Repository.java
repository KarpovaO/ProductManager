
import domain.Product;

public class Repository {
    Product[] products = new Product[0];

    public void save(Product item) {
        int newLength = products.length + 1;
        Product[] tmp = new Product[newLength];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        products = tmp;
    };

    public Product[] getAll() {
        return products;
    };



    public void removeById(int productIdToRemove) {
        if (products.length == 0) {
            return;
        }
        int newLength = products.length - 1;
        Product[] tmp = new Product[newLength];

        int indexRemove = -1;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product.getId() == productIdToRemove) {
                indexRemove = i;
                break;
            }
        }

        if (indexRemove == -1)
            return;

        if (indexRemove == 0)
            System.arraycopy(products, 1, tmp, 0, products.length - 1);
        else if (indexRemove == products.length - 1)
            System.arraycopy(products, 0, tmp, 0, products.length - 1);
        else {
            System.arraycopy(products, 0, tmp, 0, indexRemove);
            System.arraycopy(products, indexRemove + 1, tmp, indexRemove + 1, tmp.length - 1);
        }


    }



}
