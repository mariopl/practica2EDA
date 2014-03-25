package practica2.SocialMovie.Usuarios;

import practica2.auxiliar.Iterables2;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class Personas 
{
	public static Iterable<Persona> cargaPersonas(String fich)
	{
		//TODO
		Iterable<String> its = Iterables2.from(fich);
		Function<String,Persona> StringsAPersona = new Function<String,Persona>()
		{
			public Persona apply(String s) 
			{
				return new PersonaImpl(s);
			}
		};
		
		return Iterables.transform(its,StringsAPersona);
	}
	
	public static Function<Persona,Integer> Persona2Edad()
	{
		//TODO
		return new Function<Persona,Integer>()
		{
			public Integer apply(Persona p)
			{
				return p.getEdad();
			}
		};
	}
	
	public static Function<Persona,String> Persona2DNI()
	{
		//TODO
		return new Function<Persona,String>()
		{
			public String apply(Persona p)
			{
				return p.getDni();
			}
		};
	}
	
	public static Function<Persona,String> Persona2Apellidos(){
		return new Function<Persona,String>(){
			@Override
			public String apply(Persona p) {
				return p.getApellidos();
			}
		};
	}
	public static Function<Persona,String> Persona2Nombre(){
		return new Function<Persona,String>(){
			@Override
			public String apply(Persona p) {
				return p.getNombre();
			}
		};
	}
	
	public static Predicate<Persona> NombreIgualA(final String nombre)
	{		
		//TODO
		return new Predicate<Persona>()
		{
			public boolean apply(Persona p)
			{
				return p.getNombre().equals(nombre);
			}
		};
	}
	
	public static Predicate<Persona> ApellidosIgualA(final String cadena)
	{		
		//TODO
		return new Predicate<Persona>()
		{
			public boolean apply(Persona p)
			{
				return p.getApellidos().equals(cadena);
			}
		};
	}
	
	public static Predicate<Persona> ApellidosQueContienen(final String cadena){		
		return new Predicate<Persona>(){
			@Override
			public boolean apply(Persona p1) {
				return (p1.getApellidos().toLowerCase().contains(cadena.toLowerCase()));
			}
		};
	}
}
