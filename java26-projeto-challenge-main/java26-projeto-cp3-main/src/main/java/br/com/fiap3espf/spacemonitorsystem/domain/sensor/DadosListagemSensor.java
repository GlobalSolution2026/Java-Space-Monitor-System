package br.com.fiap3espf.spacemonitorsystem.domain.sensor;

public record DadosListagemSensor(
        Long id,
        String nomeSensor,
        String localizacao,
        String status,
        TipoSensor tipoSensor) {

    public DadosListagemSensor(Sensor sensor) {
        this(
                sensor.getId(),
                sensor.getNomeSensor(),
                sensor.getLocalizacao(),
                sensor.getStatus(),
                sensor.getTipoSensor()
        );
    }
}