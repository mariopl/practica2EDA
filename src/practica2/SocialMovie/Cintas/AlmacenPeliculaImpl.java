package practica2.SocialMovie.Cintas;

import java.util.SortedMap;
import java.util.SortedSet;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;

public class AlmacenPeliculaImpl implements AlmacenPelicula {

	SortedMap<String,Pelicula> tituloPelicula;
	SortedSetMultimap<String,Pelicula> directorPelicula;
	SortedSet<Pelicula> conjuntoPeliculas;
	
	public AlmacenPeliculaImpl() {
		super();
		conjuntoPeliculas=Sets.newTreeSet(Peliculas.cargaPeliculas("src/practica2/Peliculas.txt"));
		tituloPelicula=Maps.newTreeMap();
		directorPelicula=TreeMultimap.create();
		
		for (Pelicula pelicula : conjuntoPeliculas) {
			tituloPelicula.put(pelicula.getTitulo(),pelicula);
			directorPelicula.put(pelicula.getDirector(), pelicula);
		}
	}
	
	/* (non-Javadoc)
	 * @see practica2.SocialMovie.Cintas.AlmacenPelicula#peliculaXTitulo(java.lang.String)
	 */
	public Pelicula peliculaXTitulo(String titulo){
		return tituloPelicula.get(titulo);
	}
	
	/* (non-Javadoc)
	 * @see practica2.SocialMovie.Cintas.AlmacenPelicula#peliculasXDirector(java.lang.String)
	 */
	public SortedSet<Pelicula> peliculasXDirector(String director){
		return directorPelicula.get(director);
	}
	
	/* (non-Javadoc)
	 * @see practica2.SocialMovie.Cintas.AlmacenPelicula#anyadirPelicula(practica2.SocialMovie.Cintas.Pelicula)
	 */
	public boolean anyadirPelicula(Pelicula p){
		if(tituloPelicula.put(p.getTitulo(),p)==null){
			return directorPelicula.put(p.getDirector(), p); 
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see practica2.SocialMovie.Cintas.AlmacenPelicula#getTituloPelicula()
	 */
	public SortedMap<String, Pelicula> getTituloPelicula() {
		return tituloPelicula;
	}
	/* (non-Javadoc)
	 * @see practica2.SocialMovie.Cintas.AlmacenPelicula#getDirectorPelicula()
	 */
	public SortedSetMultimap<String, Pelicula> getDirectorPelicula() {
		return directorPelicula;
	}
	/* (non-Javadoc)
	 * @see practica2.SocialMovie.Cintas.AlmacenPelicula#getConjuntoPeliculas()
	 */
	public SortedSet<Pelicula> getConjuntoPeliculas() {
		return conjuntoPeliculas;
	}
	
		
	
	
}
