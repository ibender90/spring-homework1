package spring_homework1.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring_homework1.errors.NoSuchProductException;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype") //предпологаю, что несколько пользователей одновременно будут использовать корзину
public class Cart {
    private ProductRepository database;
    private List<Product> goodsAddedToCart = new ArrayList<Product>();

    @Autowired
    public void setDatabase(ProductRepository database) {
        this.database = database;
    }


    public void addProductToCart(Long id){
        try {
            goodsAddedToCart.add(database.getProduct(id));
            showCart();
        } catch (NoSuchProductException e){
            System.out.println(e.getMessage()); // так как консольное приложение
        }
    }

    public void removeProductFromCart(Long id){
        try {
            goodsAddedToCart.remove(database.getProduct(id));
            showCart();
        } catch (NoSuchProductException e){
            System.out.println(e.getMessage());
        }
    }


    private void showCart() {
        System.out.println("Your cart: ");
        for (Product p :
                goodsAddedToCart) {
            System.out.println(p.getName() + " " + p.getPrice());
        }
    }
}
