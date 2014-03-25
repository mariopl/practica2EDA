package practica2.SocialMovie.Puntuaciones;

import java.util.Map;
import java.util.Set;

public interface Asociacion {

	public abstract Integer obtenerPuntuacion(String dni, String titulo);

	public abstract void darPuntuacion(String dni, String titulo, Integer puntos);

	public abstract Map<String, Integer> notasPorTitulo(String titulo);

	public abstract Map<String, Integer> notasPorDni(String dni);

	public abstract Set<String> dnisPorTitulo(String titulo);

	public abstract Set<String> titulosPorDni(String dni);

}