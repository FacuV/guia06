package died.guia06;

import java.util.Comparator;

public class CompararAlfabeticamente implements Comparator<Alumno> {
    @Override
    public int compare(Alumno alumno1, Alumno alumno2) {
        return alumno1.getNombre().compareTo(alumno2.getNombre());
    }
}
