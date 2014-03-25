package practica2.SocialMovie.Puntuaciones;

// TODO
public class PersonaPeliculaImpl implements PersonaPelicula
{
	private String dni;
	private String titulo;
	private Integer nota;
	
	public PersonaPeliculaImpl(String s)
	{
		String[] campos=s.split(",");
		dni = campos[0];
		titulo = campos[1];
		nota = Integer.valueOf(campos[2]);
	}

	public String getDni() 
	{
		return dni;
	}

	public void setDni(String dni) 
	{
		this.dni = dni;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public Integer getPuntuacion() 
	{
		return nota;
	}

	public void setPuntuacion(Integer puntuacion) 
	{
		this.nota = puntuacion;
	}
}
