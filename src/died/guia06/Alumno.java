package died.guia06;

import java.util.ArrayList;
import java.util.List;



public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno() {
		nombre = "";
		nroLibreta = 0;
		cursando = new ArrayList<>();
		aprobados = new ArrayList<>();
	}

	public Alumno(String nombre, int nroLibreta){
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		cursando = new ArrayList<>();
		aprobados = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}


	public int creditosObtenidos() {
		int creditos = 0;
		for (Curso curso : aprobados) {
			creditos += curso.getCreditos();
		}
		return creditos;
	}

	public void aprobar(Curso c) {
		if (cursando.contains(c)) {
			aprobados.add(c);
			cursando.remove(c);
		} else {
			System.out.println("El alumno " + this.nombre + " no esta cursando el curso " + c.getNombre());
		}
	}

	public void inscripcionAceptada(Curso c) {
		cursando.add(c);
	}

	public boolean equals(Alumno alumno) {
		if (this.nroLibreta == alumno.nroLibreta) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Alumno alumno) {
		return this.nombre.compareTo(alumno.nombre);
	}

	public int cantCursando(){return cursando.size();}
	public int cantCursandoEnCicloLectivo(int cicloLectivo){
		int cantidad=0;
		for(Curso curso: cursando){
			if(curso.getCicloLectivo() == cicloLectivo){
				cantidad++;
			}
		}
		return cantidad;
	}

}