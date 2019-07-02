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
public class ClienteTestBuscaruno {
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
	public void buscarCliente189496974jose() {
		ClienteVO cliente= this.dao.findById("18949697-4").get();
		ClienteVO clienteoriginal = new ClienteVO("18949697-4", "jose luis", "corrales espinoza", "jo@gmail.com",
				"+56957827070");
		boolean soniguales =cliente.equals(clienteoriginal);
		assertTrue("Deberia ser cliente  rut 18949697-4 pero es "+ cliente.getRut(), cliente.getRut().equals("18949697-4"));
    }

}
