package br.com.fiap3espf.spacemonitorsystem.domain.sensor;

import br.com.fiap3espf.spacemonitorsystem.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoSensor(

        @NotNull
        Long id,

        String nomeSensor,
        String localizacao,
        String status,
        TipoSensor tipoSensor,
        DadosEndereco endereco) {
}