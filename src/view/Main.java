package view;

import model.Agendamento;
import model.Cliente;
import model.Pessoa;
import model.Servico;
import model.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "123456", "barber");
        System.out.println(usuario.getNome());
        
        Cliente cliente = new Cliente(1, "rua Teste", "72871",  "Gabriel");
        System.out.println(cliente.getNome());
        
        Servico servico = new Servico(1,  "Barba", (float) 30.8);
        System.out.println(servico.getDescricao());
        
        
        
    }
}
