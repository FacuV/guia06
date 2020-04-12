package excepciones;

public class ExceptionNoPoseeCreditos extends Exception {
    private String message;
    public ExceptionNoPoseeCreditos(){
        this.message = "El alumno no posee los creditos requeridos para ingresar al curso";
    }
    public ExceptionNoPoseeCreditos(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
