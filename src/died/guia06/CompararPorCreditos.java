package died.guia06;

import java.util.Comparator;

public class CompararPorCreditos implements Comparator<Alumno> {
    @Override
    public int compare(Alumno alumno1, Alumno alumno2){
        Integer creditos1 = alumno1.creditosObtenidos();
        Integer creditos2 = alumno2.creditosObtenidos();
        return creditos1.compareTo(creditos2);
    }
}
