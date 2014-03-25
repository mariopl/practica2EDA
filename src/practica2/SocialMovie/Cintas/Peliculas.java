package practica2.SocialMovie.Cintas;

import practica2.auxiliar.Iterables2;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class Peliculas {
	public static Iterable<Pelicula> cargaPeliculas(String fich){
		Iterable<String> its=Iterables2.from(fich);
		Function<String,Pelicula> StringsAPelicula=new Function<String,Pelicula>(){

			@Override
			public Pelicula apply(String s) {
				return new PeliculaImpl(s);
			}
			
		};
		
		return Iterables.transform(its, StringsAPelicula);
		
	}
	
	public static Function<Pelicula,String> Pelicula2Titulo(){
		return new Function<Pelicula,String>(){
			@Override
			public String apply(Pelicula p) {
				return p.getTitulo();
			}
		};
	}
	public static Function<Pelicula,String> Pelicula2Director(){
		return new Function<Pelicula,String>(){
			@Override
			public String apply(Pelicula p) {
				return p.getDirector();
			}
		};
	}
	
}
