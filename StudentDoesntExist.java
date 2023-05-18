public class StudentDoesntExist extends Exception {
    String message;

    public StudentDoesntExist(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "StudentDoesntExist{" +
                "message='" + message + '\'' +
                '}';
    }
}

