package excepciones;

public class ExceptionSinCupo extends Exception {
    private String message;

    public ExceptionSinCupo() {
        this.message = "Ya no hay cupo en el curso";
    }

    public ExceptionSinCupo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;

    }
}