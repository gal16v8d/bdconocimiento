package co.com.gsdd.bdconocimiento.persistencia.repositorio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class IUsuarioRepositorioTest {

	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;

	@Test
	public void findByEstadoTest() {
		// given
		// when
		Long conteo = usuarioRepositorio.count();
		// then
		Assertions.assertEquals(0, conteo);
	}

}
