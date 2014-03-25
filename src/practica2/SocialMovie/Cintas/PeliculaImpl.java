package practica2.SocialMovie.Cintas;

import java.util.Comparator;

public class PeliculaImpl implements Pelicula {

	private String titulo;
	private String director;
	private Integer duracion;
	private String distribuidora;
	private String nacionalidad;
	private Double recaudacion;
	private String divisa;
	
	public PeliculaImpl(String s){
		String[] campos=s.split(",");
		asignarCampos(campos[0],campos[1],Integer.valueOf(campos[2]),
				campos[3],campos[4]
				,Double.valueOf(campos[5]),campos[6]);
	}
	public PeliculaImpl(String titulo, String director, Integer duracion,
			String distribuidora, String nacionalidad, 
			Double recaudacion, String divisa) {
		super();
		asignarCampos( titulo,  director,  duracion,
			 distribuidora,  nacionalidad,  
			 recaudacion,  divisa);
		
	}
	public void asignarCampos(String titulo, String director, Integer duracion,
			String distribuidora, String nacionalidad, 
			Double recaudacion, String divisa){
		this.titulo = titulo;
		this.director = director;
		this.duracion = duracion;
		this.distribuidora = distribuidora;
		this.nacionalidad = nacionalidad;
		this.divisa = divisa;
		this.recaudacion = recaudacion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eda.videoclub.pelicula.Pelicula#getTitulo()
	 */
	@Override
	public String getTitulo() {
		return titulo;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eda.videoclub.pelicula.Pelicula#getDivisa()
	 */
	@Override
	public String getDivisa() {
		return divisa;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eda.videoclub.pelicula.Pelicula#getDirector()
	 */
	@Override
	public String getDirector() {
		return director;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eda.videoclub.pelicula.Pelicula#getDuracion()
	 */
	@Override
	public Integer getDuracion() {
		return duracion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eda.videoclub.pelicula.Pelicula#getDistribuidora()
	 */
	@Override
	public String getDistribuidora() {
		return distribuidora;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eda.videoclub.pelicula.Pelicula#getNacionalidad()
	 */
	@Override
	public String getNacionalidad() {
		return nacionalidad;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see eda.videoclub.pelicula.Pelicula#getRecaudacion()
	 */
	@Override
	public Double getRecaudacion() {
		return recaudacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeliculaImpl other = (PeliculaImpl) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s;
		s = "["+titulo + "," + director + "," + duracion + "," + distribuidora
				+ "," + nacionalidad + "," + recaudacion + "," + divisa+"]" ;
		return s;
	}

	//private static Comparator<Pelicula> ordenPeliculaFechaEstreno = new OrdenPeliculaFechaEstreno();
	private static Comparator<Pelicula> ordenPeliculaDuracion = new OrdenPeliculaDuracion();

	/*public static Comparator<Pelicula> getOrdenPeliculaFechaEstreno() {
		return ordenPeliculaFechaEstreno;
	}*/

	public static Comparator<Pelicula> getOrdenPeliculaDuracion() {
		return ordenPeliculaDuracion;
	}

	/*private static class OrdenPeliculaFechaEstreno implements
			Comparator<Pelicula> {
		@Override
		public int compare(Pelicula arg0, Pelicula arg1) {
			return arg0.getFechaEstreno().compareTo(arg1.getFechaEstreno());
		}
	}*/

	private static class OrdenPeliculaDuracion implements Comparator<Pelicula> {
		@Override
		public int compare(Pelicula arg0, Pelicula arg1) {
			return arg0.getDuracion().compareTo(arg1.getDuracion());
		}
	}

	@Override
	public int compareTo(Pelicula o) {
		return getTitulo().compareToIgnoreCase(o.getTitulo());
	}
}
