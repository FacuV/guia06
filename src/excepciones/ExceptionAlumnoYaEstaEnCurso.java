package excepciones;

public class ExceptionAlumnoYaEstaEnCurso extends Exception {
    private String message;
    public ExceptionAlumnoYaEstaEnCurso(){
        this.message = "El alumno ya esta dentro del curso";
    }
    public ExceptionAlumnoYaEstaEnCurso(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
