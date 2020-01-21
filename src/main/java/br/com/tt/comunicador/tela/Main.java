package br.com.tt.comunicador.tela;
import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Mensagem;
import br.com.tt.comunicador.model.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static Usuario usuarioLogado;
    private static List<Mensagem> mensagens;

    public static void main(String[] args) {

        mensagens = new ArrayList<>();
        entrar();

        do {
            novaMensagem();
            Util.print("Deseja sair? (S/N)");
            if( "S".equals( Util.read() ) ){
                break;
            }

        }while(true);
    }

    private static void entrar(){

        Util.print("Informe seu username: ");
        String userName = Util.read();

        Util.print("Informe seu nome: ");
        String nome = Util.read();

        Util.print("Informe seu nascimento (dd/mm/yyyy): ");
        String nascimentoTexto = Util.read();

        LocalDate nascimento = LocalDate.parse(nascimentoTexto, FORMATO);

        new Usuario(userName, nome, nascimento);

        usuarioLogado = new Usuario(userName, nome, nascimento);

    }

    private static void novaMensagem(){

        Util.print("Digite a mensagem: ");

        String texto = Util.read();

        Mensagem mensagem = new Mensagem(texto);

        mensagens.add(mensagem);

    }

    private static void listarMensagens(){
        for( int numero : mensagens ){
            Util.print(mensagens.toString();
        }

    }

}


