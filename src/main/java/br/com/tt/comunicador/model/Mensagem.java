package br.com.tt.comunicador.model;

import java.time.LocalDateTime;

public class Mensagem {
    private String texto;
    private LocalDateTime dataHora;

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Mensagem(String texto) {
        this.texto = texto;
        this.dataHora = LocalDateTime.now();
    }


}
