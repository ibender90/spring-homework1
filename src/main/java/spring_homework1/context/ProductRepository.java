package spring_homework1.context;

import org.springframework.stereotype.Component;
import spring_homework1.errors.NoSuchProductException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
    }

    @PostConstruct
    public void initStorage(){
        this.products  = new ArrayList<Product>();
        products.add(new Product(1L, "Helmet", 200D));
        products.add(new Product(2L, "Gloves", 80D));
        products.add(new Product(3L, "Leather jacket", 330D));
        products.add(new Product(4L, "Jeans", 160D));
        products.add(new Product(5L, "Boots", 220D));
    }

    public Product getProduct(Long id) throws NoSuchProductException {
        for (Product p :
                products) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new NoSuchProductException();
    }

    public List<Product> getAllProducts(){
        return products;
    }
}

