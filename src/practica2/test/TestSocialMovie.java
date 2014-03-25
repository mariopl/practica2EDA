package practica2.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import practica2.SocialMovie.SocialMovie;
import practica2.SocialMovie.SocialMovieImpl;
import practica2.SocialMovie.Usuarios.Personas;


public class TestSocialMovie {

	SocialMovie sm;
	@Before
	public void setUp() throws Exception {
		sm=new SocialMovieImpl();
	}
	@After
	public void tearDown() throws Exception {
		sm=null;
	}
	
	@Test
	public void test1(){
		
		//System.out.println("Peliculas que han visto los que se apellidan %Ma%");
		assertTrue("El metodo peliculasXUsuariosFiltrados no es correcto",  sm.peliculasXUsuariosFiltrados(Personas.ApellidosQueContienen("Ma")).size()== 8);
	}
	@Test
	public void test2(){
		//System.out.println("Personas que han visto Titanic");
		assertTrue("El metodo usuariosXPelicula no es correcto",sm.usuariosXPelicula("Titanic").size()==6);	
	}
	@Test
	public void test3(){
		//System.out.println("Pel’culas de James Cameron vistas por menores de edad");
		assertTrue(sm.usuariosFiltradosXEdadYDirector(0,18,"James Cameron").size()==3);
	}
	@Test
	public void test4(){
		//System.out.println("Nota media de las peliculas");
		assertTrue("El metodo getTitulos no es correcto",sm.getTitulos().size()==5);
		Double suma=0.0;
		for(String titulo:sm.getTitulos()){
			suma+=sm.notaMediaXPelicula(titulo);
		}
		assertTrue("El metodo notaMediaXPelicula no es correcto",suma==25.5);
	}
}
