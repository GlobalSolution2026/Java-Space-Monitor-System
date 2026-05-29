package br.com.fiap3espf.spacemonitorsystem.domain.alerta;

public record DadosListagemAlerta(
        Long id,
        String regiao,
        String nivelRisco,
        String intensidade,
        TipoQueimada tipoQueimada) {

    public DadosListagemAlerta(Alerta alerta) {
        this(
                alerta.getId(),
                alerta.getRegiao(),
                alerta.getNivelRisco(),
                alerta.getIntensidade(),
                alerta.getTipoQueimada()
        );
    }
}