package practica2.SocialMovie.Puntuaciones;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;

public class AsociacionImpl implements Asociacion 
{
	private Table<String,String,Integer> tabla;
	
	public AsociacionImpl()
	{
		Set<PersonaPelicula> set = Sets.newHashSet(PersonaPeliculas.cargaPersonaPelicula("src/practica2/PersonaPelicula.txt"));
		tabla = HashBasedTable.create();
		for(PersonaPelicula pp:set)
		{
			tabla.put(pp.getDni(),pp.getTitulo(),pp.getPuntuacion());
		}
	}

	public Integer obtenerPuntuacion(String dni, String titulo) 
	{
		return tabla.get(dni,titulo);
	}

	public void darPuntuacion(String dni, String titulo, Integer puntos) 
	{
		tabla.put(dni,titulo,puntos);
	}

	public Map<String, Integer> notasPorTitulo(String titulo) 
	{
		return tabla.column(titulo);
	}

	public Map<String, Integer> notasPorDni(String dni) 
	{
		return tabla.row(dni);
	}

	public Set<String> dnisPorTitulo(String titulo) 
	{
		return tabla.column(titulo).keySet();
	}

	public Set<String> titulosPorDni(String dni) 
	{
		return tabla.row(dni).keySet();
	}
}
