package br.com.fiap3espf.spacemonitorsystem.domain.sensor;

import br.com.fiap3espf.spacemonitorsystem.domain.endereco.DadosEndereco;

public record DadosDetalhamentoSensor(
        Long id,
        String nomeSensor,
        String localizacao,
        String status,
        TipoSensor tipoSensor,
        DadosEndereco endereco,
        boolean ativo) {

    public DadosDetalhamentoSensor(Sensor sensor) {
        this(
                sensor.getId(),
                sensor.getNomeSensor(),
                sensor.getLocalizacao(),
                sensor.getStatus(),
                sensor.getTipoSensor(),
                new DadosEndereco(sensor.getEndereco()),
                sensor.isAtivo()
        );
    }
}