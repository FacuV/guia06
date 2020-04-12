package died.guia06;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import died.guia06.util.Registro;

import javax.imageio.IIOException;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	public Curso(int id,String nombre,int cicloLectivo,int cupo,int creditos,int creditosRequeridos){
		this.id=id;
		this.nombre=nombre;
		this.cicloLectivo=cicloLectivo;
		this.cupo=cupo;
		this.creditos=creditos;
		this.creditosRequeridos=creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}

	public int getCreditos(){return creditos;}

	public String getNombre(){return nombre;}

	public Integer getCicloLectivo(){return cicloLectivo;}

	public List<Alumno> getInscriptos(){return inscriptos;}

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		if(!inscriptos.contains(a)){
			if(a.creditosObtenidos() >= creditosRequeridos) {
				if(inscriptos.size()<cupo) {
					if(a.cantCursandoEnCicloLectivo(cicloLectivo) < 3) {
						inscriptos.add(a);
						a.inscripcionAceptada(this);
					}else{System.out.println("El alumno no puede estar en mas de 3 cursos por ciclo lectivo");return false;}
				}else{System.out.println("El curso ya no tiene cupo");return false;}
			}else{System.out.println("El alumno no posee los creditos requeridos");return false;}
		}else{System.out.println("El alumno ya esta en el curso");return false;}

		try {log.registrar(this, "inscribir ", a.toString());
		}catch(IOException ex){
			System.err.println("An IOException was caught: " + ex.getMessage());
			ex.printStackTrace();
		}
		return true;
	}
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		System.out.println("Lista de insciptos por orden alfabetico: ");
		inscriptos.sort(new CompararAlfabeticamente());
		System.out.println(inscriptos.toString());

		System.out.println("Lista de insciptos por numero de Libreta: ");
		inscriptos.sort(new CompararPorNumLibreta());
		System.out.println(inscriptos.toString());

		System.out.println("Lista de insciptos por Creditos Obtenidos: ");
		inscriptos.sort(new CompararPorCreditos());
		System.out.println(inscriptos.toString());

		try{log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		}catch(IOException ex){
			System.err.println("An IOException was caught: " + ex.getMessage());
			ex.printStackTrace();
		}
	}


}
