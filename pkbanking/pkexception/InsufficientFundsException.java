package pkbanking.pkexception;

public class InsufficientFundsException extends Exception {
    String description;

    public InsufficientFundsException(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "InsufficientFundsException{" +
                "description='" + description + '\'' +
                '}';
    }
}
