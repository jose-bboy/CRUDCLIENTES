package banco.clientes.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import banco.clientes.modelo.ClienteVO;
import banco.clientes.modelo.dao.IClienteRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteTestModificaruno {
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	IClienteRepository dao;
	@Before
	public void setUp() throws Exception {
		ClienteVO cliente = new ClienteVO("18949697-4", "jose luis", "corrales espinoza", "jo@gmail.com",
				"+56957827070");

		this.entityManager.persist(cliente);
	}

	@Test
	public void modificarCliente189496974jose() {
		ClienteVO clienteamodificar = new ClienteVO("18949697-4", "jose antonio", "corrales espinoza", "jo@gmail.com",
				"+56957827070");
		
		boolean existe =this.dao.existsById(clienteamodificar.getRut());
		assertTrue("No existe  cliente  rut 18949697-4 ", existe==true);
        if(existe) {
			ClienteVO cli =this.dao.save(clienteamodificar);
			assertTrue("cliente  rut 18949697-4 es nulo", cli!= null);
		}
		
		
    }
	

}
