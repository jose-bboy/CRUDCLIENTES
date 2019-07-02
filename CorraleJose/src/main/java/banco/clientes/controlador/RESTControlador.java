package banco.clientes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import banco.clientes.modelo.ClienteVO;

import banco.clientes.modelo.dao.IClienteRepository;


@RestController
public class RESTControlador {
	
	@Autowired
	IClienteRepository clientedao;

	/*- READ (GET): El servicio RESTUL debera entregar la lista de todos 
	 * los clientes en formato JSON.*/
	@GetMapping("/cliente")
	public List<ClienteVO> getReadCliente() {
		return clientedao.findAll();
	}
	/*
	 *READ (GET): El servicio RESTUL debera recibir un rut como parametro y retornara
	 * UN cliente en formato JSON
	 */
	@GetMapping("/cliente/{rut}")
	public ClienteVO getReadCliente(@PathVariable String rut) {
		return clientedao.findById(rut).get();
	}
	
	/*
	 * El servicio RESTUL deberá consumir un objeto JSON e 
	 * insertarlo en la tabla, a menos que éste ya exista, caso
     * en el cual el método retornará false.
	 */
	@PostMapping("/cliente")
	public boolean createCliente(@RequestBody ClienteVO nuevo) {
		System.out.println("Cliente:"+ nuevo);
		boolean agregado= false;
		if(!clientedao.existsById(nuevo.getRut())) {
			System.out.println("**************************");
			System.out.println("GUARDANDO CLIENTE");
			agregado= true;
		clientedao.save(nuevo);
		}else {
			System.out.println("**************************");
			System.out.println("Error rut Registrado ya existe en la base de datos clientes");
			agregado= false;
		}
		return agregado;
	}
	
	/*
	 * - UPDATE (PUT): El servicio RESTUL deberá recibir un objeto JSON 
	 * y utilizarlo para modificar los datos de UN cliente en la tabla,
     *  a menos que éste no exista, 
     * caso en el cual el método retornará false.
     * */
	@PutMapping("/cliente")
	public boolean updateCliente(@RequestBody ClienteVO cliente) {
		System.out.println("Cliente:"+ cliente);
		boolean modificado= false;
		if(clientedao.existsById(cliente.getRut())) {
		clientedao.save(cliente);
		System.out.println("***************************************");
		System.out.println("Modificando Cliente.......");
		modificado= true;
		}else {
			System.out.println("Error Cliente ingresado no existe en la base de datos");
			modificado=false;
		}
		return modificado;
	}
	
	/*
	 * El servicio RESTUL deberá recibir un rut como parámetro
	 * y utilizarlo para eliminar UN cliente de la tabla. Si
     * el rut es 99999999-9 el servicio eliminará TODOS los registros de la tabla.
     * En cualquier caso, el método retornará false si no pudo
     * lograr su cometido
	 */
	
	@DeleteMapping("/cliente/{rut}")
	public boolean removeCurso(@PathVariable String rut) {
		boolean eliminado = false;
		
		if(clientedao.existsById(rut)) {
			
			clientedao.deleteById(rut);
			System.out.println("***********************************");
			System.out.println("ELIMINANDO CLIENTE..........");
			eliminado=true;
		}else if(rut.equalsIgnoreCase("99999999-9")) {
			System.out.println("Es el momento de eliminar Todo :)");
			clientedao.deleteAll();
			eliminado=true;
		}else{
			System.out.println("***********************************");
			System.out.println("ERROR, RUT CLIENTE NO EXISTE DENTRO DE LA BASE DE DATOS");
			eliminado= false;
		}
		
		return eliminado;
	}
}
