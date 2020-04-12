package excepciones;

public class ExceptionCursosPorCicloLectivoCompleto extends Exception {
    private String message;

    public ExceptionCursosPorCicloLectivoCompleto() {
        this.message = "El alumno no puede cursar mas de 3 materias por ciclo lectivo";
    }

    public ExceptionCursosPorCicloLectivoCompleto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;

    }
}
