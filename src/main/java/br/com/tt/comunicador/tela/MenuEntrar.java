package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class MenuEntrar {

    private final static DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Util util;

    public MenuEntrar( Util util) {
        this.util = util;
    }

    Usuario entrar(){

        util.print("Informe seu username: ");
        String userName = util.read();

        util.print("Informe seu nome: ");
        String nome = util.read();

        util.print("Informe seu nascimento (dd/mm/yyyy): ");
        String nascimentoTexto = util.read();

        LocalDate nascimento = LocalDate.parse(nascimentoTexto, FORMATO);

        new Usuario(userName, nome, nascimento);

        return new Usuario(userName, nome, nascimento);

    }

}
