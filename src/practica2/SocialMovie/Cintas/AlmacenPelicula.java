package practica2.SocialMovie.Cintas;

import java.util.SortedMap;
import java.util.SortedSet;

import com.google.common.collect.SortedSetMultimap;

public interface AlmacenPelicula {

	public abstract Pelicula peliculaXTitulo(String titulo);

	public abstract SortedSet<Pelicula> peliculasXDirector(String director);

	public abstract boolean anyadirPelicula(Pelicula p);

	public abstract SortedMap<String, Pelicula> getTituloPelicula();

	public abstract SortedSetMultimap<String, Pelicula> getDirectorPelicula();

	public abstract SortedSet<Pelicula> getConjuntoPeliculas();

}