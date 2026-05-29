package br.com.fiap3espf.spacemonitorsystem.domain.alerta;

import br.com.fiap3espf.spacemonitorsystem.domain.endereco.DadosEndereco;

import java.time.LocalDateTime;

public record DadosDetalhamentoAlerta(
        Long id,
        String regiao,
        String descricao,
        String nivelRisco,
        String intensidade,
        LocalDateTime dataDeteccao,
        TipoQueimada tipoQueimada,
        DadosEndereco endereco,
        boolean ativo) {

    public DadosDetalhamentoAlerta(Alerta alerta) {
        this(
                alerta.getId(),
                alerta.getRegiao(),
                alerta.getDescricao(),
                alerta.getNivelRisco(),
                alerta.getIntensidade(),
                alerta.getDataDeteccao(),
                alerta.getTipoQueimada(),
                new DadosEndereco(alerta.getEndereco()),
                alerta.isAtivo()
        );
    }
}