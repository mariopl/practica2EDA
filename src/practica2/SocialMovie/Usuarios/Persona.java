package practica2.SocialMovie.Usuarios;

public interface Persona  extends Comparable<Persona> {
	public String getDni();
	public String getNombre();
	public String getApellidos();
	public Integer getEdad();
	public void setEdad(Integer edad);
}
