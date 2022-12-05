package spring_homework1.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(ContextConfig.class);
        Cart cart = context.getBean(Cart.class);
        Scanner scanner = new Scanner(System.in);

        showAvailableProducts();
        while (scanner.hasNextLine()){
            Integer input = 0;
            try{
                input = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Enter a number");
                scanner.next();
                continue;
            }
            if(input == 0){
                System.out.println("Goodbye!");
                break;
            }
            if(input > 0){
                cart.addProductToCart(Integer.toUnsignedLong(input));
            } else if(input < 0) {
                cart.removeProductFromCart(Integer.toUnsignedLong(Math.abs(input)));
            }
        }
    }

    private static void showAvailableProducts(){
        System.out.println("#######################################");
        System.out.println("Choose product number to add to cart, to remove use -number, and 0 to exit");
        List<Product> products = context.getBean(ProductRepository.class).getAllProducts();
        for (Product p :
                products) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
        }
        System.out.println("#######################################");
    }
}
