package banco.clientes.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import banco.clientes.modelo.ClienteVO;
@Repository
public interface IClienteRepository  extends JpaRepository<ClienteVO, String>{

}
