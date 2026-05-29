package br.com.fiap3espf.spacemonitorsystem.domain.alerta;

import br.com.fiap3espf.spacemonitorsystem.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroAlerta(

        @NotBlank
        String regiao,

        @NotBlank
        String descricao,

        @NotBlank
        String nivelRisco,

        @NotBlank
        String intensidade,

        @NotNull
        LocalDateTime dataDeteccao,

        @NotNull
        TipoQueimada tipoQueimada,

        @Valid
        DadosEndereco endereco) {
}