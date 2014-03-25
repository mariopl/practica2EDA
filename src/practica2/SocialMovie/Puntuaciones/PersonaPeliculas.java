package practica2.SocialMovie.Puntuaciones;

import practica2.SocialMovie.Puntuaciones.PersonaPeliculaImpl;
import practica2.auxiliar.Iterables2;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class PersonaPeliculas {
	public static Iterable<PersonaPelicula> cargaPersonaPelicula(String fich){
		Iterable<String> its=Iterables2.from(fich);
		Function<String,PersonaPelicula> StringsAPersonaPelicula=new Function<String,PersonaPelicula>(){

			@Override
			public PersonaPelicula apply(String s) {
				return new PersonaPeliculaImpl(s);
			}
			
		};
		
		return Iterables.transform(its, StringsAPersonaPelicula);
		
	}
	
	public static  Function<PersonaPelicula,String> PersonaPelicula2DNI(){
		return new Function<PersonaPelicula,String>(){
			@Override
			public String apply(PersonaPelicula p) {
				return p.getDni();
			}
		};
	}
	public static  Function<PersonaPelicula,String> PersonaPelicula2Titulo(){
		return new Function<PersonaPelicula,String>(){
			@Override
			public String apply(PersonaPelicula p) {
				return p.getTitulo();
			}
		};
	}
	public static  Function<PersonaPelicula,Integer> PersonaPelicula2Puntuacion(){
		return new Function<PersonaPelicula,Integer>(){
			@Override
			public Integer apply(PersonaPelicula p) {
				return p.getPuntuacion();
			}
		};
	}
}
