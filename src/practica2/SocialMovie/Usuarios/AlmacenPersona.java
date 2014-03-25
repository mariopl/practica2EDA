package practica2.SocialMovie.Usuarios;

import java.util.SortedSet;

public interface AlmacenPersona {

	public Persona personaXDni(String dni);

	public SortedSet<Persona> personaXEdad(Integer edad);

	public boolean anyadirPersona(Persona p);

	public SortedSet<Persona> getConjuntoPersonas();

}