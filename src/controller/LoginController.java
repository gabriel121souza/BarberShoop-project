package Controller;

import View.Login;
import Controller.helper.LoginHelper;
import model.DAO.UsuarioDAO;
import View.MenuPrincipal;
import model.Usuario;

public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper =  new LoginHelper(view);
        
    }
    public void entrarNoSistema(){
         //Pegar os usuarios da View
         Usuario usuario = helper.obterModelo();
        
        //Pesquisar usuario no Banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        //se o usuario da view tiver o mesmo e usaurio e senha do banco direcionar para o menu
            if(usuarioAutenticado != null){
                //navegar para menu principal
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                //sumir a tela de login
                this.view.dispose();
            }else{
                view.exibeMensagem("usuario ou senha invalidos");
            }
        //senao mostrar mensagem ao usuario  ou senha "invalidos "
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
}
