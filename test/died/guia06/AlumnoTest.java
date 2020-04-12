package died.guia06;

import static org.junit.jupiter.api.Assertions.*;
import died.guia06.Alumno;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AlumnoTest {

	Curso cursar = new Curso(01,"curso1",0,3,2,0);
	Curso aprobar = new Curso(02,"curso2",0,3,2,0);
	Curso inscribir = new Curso(03,"curso3",0,3,2,0);
	Alumno alumno1 = new Alumno("jose",001);


	@Test
	void testCreditosObtenidos() {
		ArrayList<Curso> list = new ArrayList<>();
		list.add(aprobar);
		alumno1.setAprobados(list);
		int esperado = alumno1.creditosObtenidos();
		assertEquals(2,esperado);

	}

	@Test
	void testAprobar() {
		ArrayList<Curso> list = new ArrayList<>();
		list.add(cursar);
		alumno1.setCursando(list);
		alumno1.aprobar(cursar);
		assertTrue(alumno1.getAprobados().contains(cursar) && !(alumno1.getCursando().contains(cursar)));
	}

	@Test
	void testInscripcionAceptada() {
		alumno1.inscripcionAceptada(inscribir);
		assertTrue(alumno1.getCursando().contains(inscribir));
	}

}
