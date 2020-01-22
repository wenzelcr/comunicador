package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.exceptions.TamanhoMensagemInvalidoException;
import br.com.tt.comunicador.model.Mensagem;

class MenuMensagem {

    private Util util;

    public MenuMensagem(Util util) {
        this.util = util;
    }

    Mensagem novaMensagem() throws TamanhoMensagemInvalidoException{

        util.print("Digite a mensagem: ");
        String texto = util.read();

        try {
            return new Mensagem(texto);

        } catch (TamanhoMensagemInvalidoException e) {
            System.err.println(e);
            util.print(e.getMessage());
            throw e;
        }

    }
}
