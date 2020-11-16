/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.DAO.ServicoDAO;
import model.DAO.ClienteDAO;
import View.Agenda;
import controller.helper.AgendaHelper;
import java.util.ArrayList;
import model.Agendamento;
import model.Cliente;
import model.DAO.AgendamentoDAO;
import model.Servico;
import servico.Correio;

/**
 *
 * @author Gabriel
 */
public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        //buscar lista com agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        //exibir lista na view
        helper.preencherTabela(agendamentos);
        
    }
    
    public void atualizarCliente(){
        //Buscar cliente do banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        //exibir clientes no combobox
        helper.preencherClientes(clientes);
    }
    
    public void atualizarServico(){
        //buscar servico do banco de dados 
        ServicoDAO servicoDAO = new ServicoDAO();
       ArrayList<Servico> servicos = servicoDAO.selectAll();
        helper.preencherServico(servicos);
    }
    
    public void atualizaValor(){
       Servico servico =  helper.obterServico();
       helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        //buscar objeto agendamento da tela
          Agendamento agendamento = helper.obterModelo();
        //salvar objeto no banco de dados
        new AgendamentoDAO().insert(agendamento);
      
        
        Correio correio = new Correio(); 
        correio.NotificarPorEmail(agendamento);

    //inserir elemento na tabela
        atualizaTabela();
        helper.limparTela();
        
       
                
    }
}
