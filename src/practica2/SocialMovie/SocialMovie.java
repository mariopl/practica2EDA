package practica2.SocialMovie;

import java.util.Map;
import java.util.SortedSet;

import practica2.SocialMovie.Cintas.Pelicula;
import practica2.SocialMovie.Usuarios.Persona;

import com.google.common.base.Predicate;
import com.google.common.collect.SortedSetMultimap;

public interface SocialMovie {

	public SortedSet<Pelicula> peliculasCalificadasXDni(String dni);

	public  Double notaMediaXDni(String dni);

	public  Double notaMediaXUsuarioYDirector(String dni,
			String director);

	public  Double notaMediaXPelicula(String titulo);

	public  SortedSetMultimap<Persona, Pelicula> peliculasXUsuariosFiltrados(
			Predicate<Persona> condicion);

	public  SortedSet<Pelicula> peliculasXUsuario(String dni);

	public  SortedSet<Persona> usuariosFiltradosXEdadYDirector(
			Integer edadMenor, Integer edadMayor, String director);

	public  Map<Persona, Integer> usuariosXPelicula(String titulo);

	public  Double notaMediaXedad(Integer edadMenor, Integer edadMayor,
			String titulo);

	public  SortedSet<String> getTitulos();

}