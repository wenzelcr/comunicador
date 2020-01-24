package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.exceptions.TamanhoMensagemInvalidoException;
import br.com.tt.comunicador.model.Mensagem;

class MenuMensagem {

    private Util util;

    MenuMensagem(Util util){
        this.util = util;
    }

    Mensagem novaMensagem(){
        util.print("Mensagem: ");
        String texto = util.read();
        try {
            return new Mensagem(texto);

        }catch (TamanhoMensagemInvalidoException e){
            System.err.println(e);
            util.print(e.getMessage());
            return null;
        } /*finally {
            algo que sempre deve executar...
        }*/
        //dataHora.format(
        // DateTimeFormatter.ofPattern("dd/MM/yyy"));
    }

    /**
     * Copiado apenas para atender outro cenário de teste.
     */
    Mensagem novaMensagemComExcecao() throws TamanhoMensagemInvalidoException {
        util.print("Mensagem: ");
        String texto = util.read();
        try {
            return new Mensagem(texto);

        }catch (TamanhoMensagemInvalidoException e){
            System.err.println(e);
            util.print(e.getMessage());
            throw e;
        } /*finally {
            algo que sempre deve executar...
        }*/
        //dataHora.format(
        // DateTimeFormatter.ofPattern("dd/MM/yyy"));
    }
}