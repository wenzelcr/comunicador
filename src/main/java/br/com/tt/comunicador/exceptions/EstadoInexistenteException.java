package br.com.tt.comunicador.exceptions;
public class EstadoInexistenteException extends Exception{
    public EstadoInexistenteException(String mensagem) {
        super(mensagem);
    }
}