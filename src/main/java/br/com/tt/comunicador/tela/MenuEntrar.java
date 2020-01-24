package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.enumerators.EstadoEnum;
import br.com.tt.comunicador.exceptions.EstadoInexistenteException;
import br.com.tt.comunicador.model.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class MenuEntrar {

    private final static DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Util util;

    public MenuEntrar( Util util) {
        this.util = util;
    }

    Usuario entrar() throws EstadoInexistenteException {
        util.print("Informe seu username:");
        String username = util.read();
/*        if(username.equals("admin")){
            throw new IllegalArgumentException("Admin não habilitado");
        }*/
        util.print("Informe seu nome:");
        String nome = util.read();
        util.print("Informe a sigla do seu estado:");
        EstadoEnum estadoEnum;
        String estado = util.read();
        try {
            estadoEnum = EstadoEnum.valueOf(estado);
        }catch (IllegalArgumentException e){
            throw new EstadoInexistenteException("Estado inexistente: "+estado);
        }
        util.print("Informe seu nascimento (dd/mm/yyyy)");
        String nascimentoTexto = util.read();
        LocalDate nascimento =
                LocalDate.parse(nascimentoTexto, FORMATO);
        return new Usuario(username, nome, estadoEnum, nascimento);
    }

}
