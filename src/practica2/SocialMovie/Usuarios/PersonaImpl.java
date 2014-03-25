package practica2.SocialMovie.Usuarios;

//import java.util.List;

//import com.google.common.collect.Lists;


public class PersonaImpl implements Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private Integer edad;
	


	public PersonaImpl(String s) {
		//TODO
		String[] campos=s.split(",");
		dni = campos[0];
		nombre = campos[1];
		apellidos = campos[2];
		edad = Integer.parseInt(campos[3]);
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		if(edad < 0) {
			throw new IllegalArgumentException("La edad debe ser positiva");
		}
		
		this.edad = edad;
	}

	

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((getApellidos() == null) ? 0 : getApellidos().hashCode());
		result = prime * result + ((getDni() == null) ? 0 : getDni().hashCode());
		result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
		
		return result;
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		PersonaImpl other = (PersonaImpl) obj;
		
		if(getApellidos() == null) {
			if(other.getApellidos() != null) {
				return false;
			}
		}
		else if(!getApellidos().equals(other.getApellidos())) {
			return false;
		}
		
		if(getDni() == null) {
			if(other.getDni() != null) {
				return false;
			}
		}
		else if(!getDni().equals(other.getDni())) {
			return false;
		}
		
		if(getNombre() == null) {
			if(other.getNombre() != null) {
				return false;
			}
		}
		else if(!getNombre().equals(other.getNombre())) {
			return false;
		}
		
		return true;
	}

	public String toString() {
		return "["+getDni() + ", " + getNombre() + ", " + getApellidos()+", " +getEdad()+"]";
	}

	public int compareTo(Persona persona) {
		if(getApellidos().compareToIgnoreCase(persona.getApellidos()) == 0) {
			if(getNombre().compareToIgnoreCase(persona.getNombre()) == 0) {
				return getDni().compareTo(persona.getDni());
			}
			else {
				return getNombre().compareToIgnoreCase(persona.getNombre());
			}
		}
		else {
			return getApellidos().compareToIgnoreCase(persona.getApellidos());
		}
	}
}
