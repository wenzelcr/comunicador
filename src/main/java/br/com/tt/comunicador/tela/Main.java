package br.com.tt.comunicador.tela;
import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.exceptions.EstadoInexistenteException;
import br.com.tt.comunicador.exceptions.TamanhoMensagemInvalidoException;
import br.com.tt.comunicador.model.Mensagem;
import br.com.tt.comunicador.model.Usuario;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Usuario usuarioLogado;
    private static List<Mensagem> mensagens;
    private static Util util = new Util();
    private static MenuEntrar menuEntrar = new MenuEntrar(util);
    private static MenuMensagem menuMensagem = new MenuMensagem(util);

    public static void main(String[] args) throws EstadoInexistenteException {

        mensagens = new ArrayList<>();
        usuarioLogado = menuEntrar.entrar();

        do {

            Mensagem msg = menuMensagem.novaMensagem();
            if( msg != null) {
                mensagens.add(msg);
            }

            util.print("Deseja sair? (S/N)");
            if( "S".equals( util.read() ) ){
                break;
            }

        }while(true);
        listarMensagens();
    }


    private static void listarMensagens(){
        String descricoes = new String();
        for( Mensagem msg : mensagens ){
            descricoes = descricoes + msg.getDescricao() + "\n";
        }
        util.print(descricoes);
    }

}


