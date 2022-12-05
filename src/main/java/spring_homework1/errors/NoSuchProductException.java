package spring_homework1.errors;

public class NoSuchProductException extends Throwable{
    private final String message = "Product with given id (number) does not exist";

    public String getMessage(){
        return message;
    }
}
