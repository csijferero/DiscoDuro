package dao;

import java.util.List;
import java.util.ArrayList;

import bean.Alumno;

public class AlumnoDAOImplListas implements AlumnoDAO {

	private List<Alumno> alumnos = new ArrayList<>();

	@Override
	public void anadirAlumno(Alumno a) {
		alumnos.add(a);
	}

	@Override
	public Alumno buscaPorNombre(String nombre) {
		return buscaAlumno(1, nombre);
	}

	@Override
	public Alumno buscaPorApellidos(String apellidos) {
		return buscaAlumno(2, apellidos);
	}

	@Override
	public Alumno buscaPorEdad(Integer edad) {
		return buscaAlumno(3, edad);
	}

	@Override
	public Alumno buscaPorNota(Float nota) {
		return buscaAlumno(4, nota);
	}

	@Override
	public Alumno busca(String patron) {
		return buscaAlumno(0, patron);
	}

	private Alumno buscaAlumno(int i, Object valor) {
		for (Alumno alumno : alumnos) {
			switch (i) {
			case 0:
				if (alumno.toString().toUpperCase().contains(((String)valor).toUpperCase()))
					return alumno;
				break;
			case 1:
				if (alumno.getNombre().equalsIgnoreCase((String)valor))
					return alumno;
				break;
			case 2:
				if (alumno.getApellidos().equalsIgnoreCase((String)valor))
					return alumno;
				break;
			case 3:
				if (alumno.getEdad() == ((Integer)valor))
					return alumno;
				break;
			case 4:
				if (alumno.getNota_expediente() == ((Integer)valor))
					return alumno;
				break;
			default:
				break;
			}

		}
		return null;
		
	}

}
