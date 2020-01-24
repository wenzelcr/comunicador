package br.com.tt.comunicador.model;
import br.com.tt.comunicador.enumerators.EstadoEnum;

import java.time.LocalDate;

public class Usuario {
    private String username;
    private String nome;
    private LocalDate nascimento;
    private EstadoEnum estado;

    public Usuario(String username, String nome, EstadoEnum estado, LocalDate nascimento) {
        this.username = username;
        this.nome = nome;
        this.nascimento = nascimento;
        this.estado = estado;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }


    public int idade(){

        return LocalDate.now().getYear() - nascimento.getYear();
    }
}
