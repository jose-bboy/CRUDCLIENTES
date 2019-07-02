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
public class ClienteTestListar {
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
	public void cuandoelistoclientesretorna1() {
	  int largo= this.dao.findAll().size();
	  assertTrue("deberian ser 1 y son"+ largo, largo==1);
	}


}
