package teste;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.Cliente;
import repositorio.RepositorioCliente;

public class TestaLoja {

	public static void main(String[] args) throws ParseException {
		
		Cliente c = new Cliente();
		RepositorioCliente RC = new RepositorioCliente();
		
		c.setCpf("11122233344");
		c.setNome("Gianlucca Rocha");
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		c.setDatanascimento(formato.parse("25/01/2003"));
		
		RC.salvar(c);
		
		
		
		System.out.println(c.getCodcliente());
		
		c.setNome("Maria Rocha");
		
		RC.salvar(c);
		
		Cliente c2 = RC.listarCliente(5);
		
		RC.remover(c2);
		
		RC.finalize();

	}

}
