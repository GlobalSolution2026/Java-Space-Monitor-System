package br.com.fiap3espf.spacemonitorsystem.domain.sensor;

import br.com.fiap3espf.spacemonitorsystem.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroSensor(

        @NotBlank
        String nomeSensor,

        @NotBlank
        String localizacao,

        @NotBlank
        String status,

        @NotNull
        TipoSensor tipoSensor,

        @Valid
        DadosEndereco endereco) {
}