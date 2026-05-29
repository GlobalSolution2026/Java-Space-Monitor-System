package br.com.fiap3espf.spacemonitorsystem.domain.sensor;

import br.com.fiap3espf.spacemonitorsystem.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Sensor")
@Table(name = "sensores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeSensor;
    private String localizacao;
    private String status;

    @Enumerated(EnumType.STRING)
    private TipoSensor tipoSensor;

    @Embedded
    private Endereco endereco;

    private boolean ativo = true;

    public Sensor(DadosCadastroSensor dados) {
        this.nomeSensor = dados.nomeSensor();
        this.localizacao = dados.localizacao();
        this.status = dados.status();
        this.tipoSensor = dados.tipoSensor();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoSensor dados) {

        if (dados.nomeSensor() != null && !dados.nomeSensor().isBlank()) {
            this.nomeSensor = dados.nomeSensor();
        }

        if (dados.localizacao() != null && !dados.localizacao().isBlank()) {
            this.localizacao = dados.localizacao();
        }

        if (dados.status() != null && !dados.status().isBlank()) {
            this.status = dados.status();
        }

        if (dados.tipoSensor() != null) {
            this.tipoSensor = dados.tipoSensor();
        }

        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}