package br.com.fiap3espf.spacemonitorsystem.domain.alerta;

import br.com.fiap3espf.spacemonitorsystem.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizacaoAlerta(

        @NotNull
        Long id,

        String regiao,
        String descricao,
        String nivelRisco,
        String intensidade,
        LocalDateTime dataDeteccao,
        TipoQueimada tipoQueimada,
        DadosEndereco endereco) {
}