package br.com.tt.comunicador.enumerators;

public enum EstadoEnum {
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    PR("Paraná"),
    MT("Mato Grosso");

    private String descricao;

    EstadoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
