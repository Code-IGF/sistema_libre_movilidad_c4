package fia.ues.sistema_libre_movilidad;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fia.ues.sistema_libre_movilidad.Entidad.Usuario;
import fia.ues.sistema_libre_movilidad.Repositorio.UsuarioRepositorio;

@SpringBootTest
class SistemaLibreMovilidadApplicationTests {

	@Autowired
    private UsuarioRepositorio repositorio;

	@Autowired
	public BCryptPasswordEncoder encoder;

	@Test
	void crearUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNombre("SR");
		usuario.setApellido("Administrador");
		usuario.setFechaNacimiento("01/01/2000");
		usuario.setSexo("M");
		usuario.setRol("Administrador");
		usuario.setTelefono("77777777");
		usuario.setCorreo("admin@admin.com");
		usuario.setContrasenia(encoder.encode("1234"));
		Usuario userReturn=repositorio.save(usuario);

		assertTrue(userReturn.getContrasenia().equalsIgnoreCase(usuario.getContrasenia()));

	}

}
