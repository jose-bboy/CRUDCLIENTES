package banco.clientes.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClienteTestAgregar.class, ClienteTestBuscaruno.class, ClienteTestEliminar.class,
		ClienteTestListar.class, ClienteTestModificaruno.class })
public class AllTestsClientes {

}
