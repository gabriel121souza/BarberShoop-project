/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import model.Agendamento;

/**
 *
 * @author Gabriel
 */
public class Correio {
    public void NotificarPorEmail(Agendamento agendamento){
        String emailFormatado = formatarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();
        
        
        //uso da classe de email
        Email email = new Email("Agendamento BarbeShop", emailFormatado, destinatario);
        email.enviar();
        
    }

    private String formatarEmail(Agendamento agendamento) {
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        float valor = agendamento.getValor();
        
        return "Eai "+ nomeCliente + "vai dar um tapa no visual... Seu agendamento para "+ servico + ", esta marcado para o dia " + 
                dataAgendamento + " as " + horaAgendamento + "O preco para voce vai sair baratin fica R$ " + valor + "Forte Abraco";
    }
}
