package died.guia06;

import excepciones.ExceptionAlumnoYaEstaEnCurso;
import excepciones.ExceptionCursosPorCicloLectivoCompleto;
import excepciones.ExceptionNoPoseeCreditos;
import excepciones.ExceptionSinCupo;

import java.lang.reflect.Array;
import java.util.List;

public class App {

	public static void main(String[] args){
		Alumno[] alumnos = {
		new Alumno("Juan",001),
		new Alumno("Jose",002),
		new Alumno("Facundo",003),
		new Alumno("Eira",004)};

		Curso[] cursos = {
		new Curso(1, "curso1", 1, 2, 3, 0),
		new Curso(2, "curso2", 1, 2, 3, 0),
		new Curso(3, "curso3", 1, 2, 3, 0),
		new Curso(4, "curso4", 1, 2, 3, 0),
		new Curso(5, "curso5", 2, 2, 2, 6),
		new Curso(6, "curso6", 2, 2, 2, 6),
		new Curso(7, "curso7", 2, 2, 2, 6),
		new Curso(8, "curso8", 2, 2, 2, 6)};
		//Jose y Juan se inscriben a los primeros 3 cursos y Facundo y Eira solo en el 4to
		System.out.println("Inscribiendo alumnos a los prieros 4 cursos");
		for(int i=0;i < 4;i++){
			for(Alumno alumno:alumnos){
				try{
					cursos[i].inscribirAlumno(alumno);
				}catch(ExceptionAlumnoYaEstaEnCurso e){
					e.printStackTrace();
				}catch(ExceptionNoPoseeCreditos e){

					e.printStackTrace();
				}catch(ExceptionSinCupo e){

					e.printStackTrace();
				}catch(ExceptionCursosPorCicloLectivoCompleto e){

					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}
		//Jose y Juan aprueban a los primeros 3 cursos y Facundo y Eira solo en el 4to
		System.out.println("Los alumnos aprueban los cursos");
		for(int i=0;i < 4;i++){
			for(Alumno alumno:alumnos){
				alumno.aprobar(cursos[i]);
			}
		}
		//Creditos de cada alumno
		System.out.println("Se imprimen los creditos de cada alumno");
		for(Alumno alumno:alumnos){
			System.out.println( "Creditos de " +alumno.getNombre()+" "+ alumno.creditosObtenidos());
		}
		//Jose y Juan se inscriben a los cursos 5,6 y 7 y Facundo y Eira en ninguno
		System.out.println("Se intenta inscribir a los alumnos a los siguientes 4 cursos");
		for(int i=0;i < 4;i++){
			for(Alumno alumno:alumnos){
				try{
					cursos[i].inscribirAlumno(alumno);
				}catch(ExceptionAlumnoYaEstaEnCurso e){
					e.printStackTrace();
				}catch(ExceptionNoPoseeCreditos e){

					e.printStackTrace();
				}catch(ExceptionSinCupo e){

					e.printStackTrace();
				}catch(ExceptionCursosPorCicloLectivoCompleto e){

					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}
	}
}
