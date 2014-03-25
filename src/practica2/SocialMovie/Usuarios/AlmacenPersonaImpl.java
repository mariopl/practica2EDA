package practica2.SocialMovie.Usuarios;

import java.util.SortedMap;
import java.util.SortedSet;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;

public class AlmacenPersonaImpl implements AlmacenPersona  
{
	private SortedMap<String,Persona> dniPersona;
	private SortedSetMultimap<Integer,Persona> edadPersona;
	private SortedSet<Persona> conjuntoPersona;
	
	public AlmacenPersonaImpl() 
	{
		conjuntoPersona = Sets.newTreeSet(Personas.cargaPersonas("src/practica2/Personas.txt"));
		dniPersona = Maps.newTreeMap();
		edadPersona = TreeMultimap.create();
		
		for (Persona persona : conjuntoPersona) 
		{
			dniPersona.put(persona.getDni(),persona);
			edadPersona.put(persona.getEdad(),persona);
		}
	}

	public Persona personaXDni(String dni) 
	{
		return dniPersona.get(dni);
	}

	public SortedSet<Persona> personaXEdad(Integer edad) 
	{
		return edadPersona.get(edad);
	}

	public boolean anyadirPersona(Persona p) 
	{
		boolean ret = false;
		Persona p2 = dniPersona.put(p.getDni(),p);
		if(p2 == null)
		{
			ret = true;
			edadPersona.put(p.getEdad(),p);
		}
		return ret;
	}

	public SortedSet<Persona> getConjuntoPersonas() 
	{
		return conjuntoPersona;
	}
}
