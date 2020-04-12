package died.guia06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CursoTest {
    Alumno alumno1 = new Alumno("juan",002);
    Curso curso1 = new Curso(01,"curso1",0,3,2,0);
    @Test
     void testInscribir(){
        boolean respuesta = curso1.inscribir(alumno1);
        assertTrue(respuesta && curso1.getInscriptos().contains(alumno1) && alumno1.getCursando().contains(curso1));
    }
    @Test
    void testinscribirAlumno() throws Exception {
        curso1.inscribirAlumno(alumno1);
        assertTrue(curso1.getInscriptos().contains(alumno1) && alumno1.getCursando().contains(curso1));
    }

}
