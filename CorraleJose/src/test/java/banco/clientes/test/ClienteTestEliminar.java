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
public class ClienteTestEliminar {
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
	public void cuandoelimina1son0clientes() {
	 this.dao.deleteById("18949697-4");
	  int largo= this.dao.findAll().size();
	  assertTrue("deberian ser 4 y son"+ largo, largo==0);
	}
	@Test
	public void cuandointentaeliminaunclieentequenoexiste() {
		 boolean existe =this.dao.existsById("xxxxxxx-4");
		 if(existe) {
	     this.dao.deleteById("18949697-4");
		 }
	  
	  assertTrue("cliente no existe", existe==false);
	}

}
