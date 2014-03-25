package practica2.SocialMovie;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import practica2.SocialMovie.Cintas.AlmacenPelicula;
import practica2.SocialMovie.Cintas.AlmacenPeliculaImpl;
import practica2.SocialMovie.Cintas.Pelicula;
import practica2.SocialMovie.Cintas.Peliculas;
import practica2.SocialMovie.Puntuaciones.Asociacion;
import practica2.SocialMovie.Puntuaciones.AsociacionImpl;
import practica2.SocialMovie.Usuarios.AlmacenPersona;
import practica2.SocialMovie.Usuarios.AlmacenPersonaImpl;
import practica2.SocialMovie.Usuarios.Persona;
import practica2.auxiliar.Iterables2;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;

public class SocialMovieImpl implements SocialMovie {
	
	private AlmacenPersona usuarios;
	private AlmacenPelicula peliculas;
	private Asociacion puntuaciones;
	
	public SocialMovieImpl() 
	{
		//TODO
		usuarios = new AlmacenPersonaImpl();
		peliculas = new AlmacenPeliculaImpl();
		puntuaciones = new AsociacionImpl();
	}
	
	//Conjunto de títulos de películas
	public SortedSet<String> getTitulos() 
	{
		//TODO
		return Sets.newTreeSet(peliculas.getTituloPelicula().keySet());
	}
	
	// Personas que han visto una determinada película y nota asociada.
	public Map<Persona,Integer> usuariosXPelicula(String titulo)
	{
		//TODO
		Map<Persona,Integer> ret = Maps.newHashMap();
		Map<String,Integer> map = puntuaciones.notasPorTitulo(titulo);
		for(String s:map.keySet())
		{
			ret.put(usuarios.personaXDni(s),map.get(s));
		}
		
		return ret;
	}
	
	//Nota media de una película
	public Double notaMediaXPelicula(String titulo)
	{
		//TODO
		Map<String,Integer> map = puntuaciones.notasPorTitulo(titulo);
		Double ret = 0.0;
		if(map.size() != 0)
			ret = (double)Iterables2.sum(map.values())/map.size();
		
		return ret;
	}
	
	// Nota media de una persona a las películas de un director determinado.
	public Double notaMediaXUsuarioYDirector(String dni,String director)
	{
		//TODO
		Set<String> peliculasPorDniYDirector = Sets.newHashSet(Iterables.transform(peliculas.peliculasXDirector(director),Peliculas.Pelicula2Titulo()));
		peliculasPorDniYDirector.retainAll(puntuaciones.titulosPorDni(dni));
		
		Double cont = 0.0;
		for(String titulo:peliculasPorDniYDirector)
		{
			cont += puntuaciones.obtenerPuntuacion(dni,titulo);
		}
		
		return cont/peliculasPorDniYDirector.size();
	}
	
	//Peliculas vistas por una determinada persona
	public SortedSet<Pelicula> peliculasCalificadasXDni(String dni)
	{
		Map<String,Integer> tituloPuntuacion=puntuaciones.notasPorDni(dni);
		SortedSet<Pelicula> peliculasVistas=Sets.newTreeSet();
		for(String titulo:tituloPuntuacion.keySet()){
			peliculasVistas.add(peliculas.peliculaXTitulo(titulo));
		}
		return peliculasVistas;
	}
	
	// Nota media que suele poner un determinado usuario a las pel’culas
	public Double notaMediaXDni(String dni)
	{
		Integer total=0,contador=0;
		Map<String,Integer> dniPuntuacion=puntuaciones.notasPorDni(dni);
		for (Map.Entry<String, Integer> puntos : dniPuntuacion.entrySet()) {
			total+=puntos.getValue();
			contador++;
		}
		if (contador==0) {
			return 0.0;
		}
		return new Double(total/contador);
	}
	
	// Personas que cumplen una serie de condiciones y las películas que han visto.
	public SortedSetMultimap<Persona,Pelicula> peliculasXUsuariosFiltrados(Predicate<Persona> condicion)
	{
		SortedSetMultimap<Persona,Pelicula> ret = TreeMultimap.create();
		
		for(Persona persona:Iterables.filter(usuarios.getConjuntoPersonas(),condicion))
		{
			for(Pelicula pelicula:this.peliculasXUsuario(persona.getDni()))
			{
				ret.put(persona,pelicula);
			}
		}
		
		return ret;
	}
	
	// Peliculas que ha visto una determinada persona.
	public SortedSet<Pelicula> peliculasXUsuario(String dni)
	{
		SortedSet<Pelicula> res=Sets.newTreeSet();
		for(String titulo: puntuaciones.notasPorDni(dni).keySet()){
			res.add(peliculas.peliculaXTitulo(titulo));
		}
		return res;
	}
	
	//Usuarios en un rango de edad que ha visto una pel’cula de un director determinado
	public SortedSet<Persona> usuariosFiltradosXEdadYDirector(Integer edadMenor,Integer edadMayor,String director)
	{
		//TODO
		// Así no se puede a no ser que edadMenor y edadMayor estén declarados como final
		/*Predicate<Persona> predicado = new Predicate<Persona>()
		{
			public boolean apply(Persona p)
			{
				return p.getEdad() >= edadMenor2 && p.getEdad()<= edadMayor2;
			}
		};*/
		SortedSet<Persona> ret = Sets.newTreeSet();
		SortedSet<Persona> aux = Sets.newTreeSet();
		for(Persona p:usuarios.getConjuntoPersonas())
		{
			if(p.getEdad()>=edadMenor && p.getEdad()<=edadMayor)
			{
				aux.add(p);
			}
		}
		for(Persona p:aux)
		{
			Set<String> aux2 = Sets.newHashSet(Iterables.transform(this.peliculasXUsuario(p.getDni()),Peliculas.Pelicula2Director()));
			if(aux2.contains(director))
			{
				ret.add(p);
			}
		}
		
		return ret;
	}
	
	//Nota media de una película por parte de personas que tienen un rango de edades.
	public Double notaMediaXedad(Integer edadMenor,Integer edadMayor, String titulo)
	{
		Iterable<Persona> personasRangoEdades=Sets.newTreeSet();
		Integer total=0,contador=0;
		
		for(int i=edadMenor;i<edadMayor;i++){
			personasRangoEdades=Iterables.concat(personasRangoEdades,usuarios.personaXEdad(i));
		}
		for (Persona p : personasRangoEdades) {
			
			Integer puntuacion=puntuaciones.obtenerPuntuacion(p.getDni(), titulo);
			if(puntuacion!=null){
				total+=puntuacion;
				contador++;
			}
		}
			
		if (contador==0) 
		{
			return 0.0;
		}
		return new Double(total/contador);
	}
}
