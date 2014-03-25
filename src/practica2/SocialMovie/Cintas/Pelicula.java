package practica2.SocialMovie.Cintas;


public interface Pelicula extends Comparable<Pelicula>{

	public String getTitulo();

	public String getDirector();

	public Integer getDuracion();

	public String getDistribuidora();

	public String getNacionalidad();

	public Double getRecaudacion();
	
	public String getDivisa();

}