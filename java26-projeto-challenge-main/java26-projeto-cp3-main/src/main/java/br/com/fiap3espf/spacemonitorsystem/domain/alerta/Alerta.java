package br.com.fiap3espf.spacemonitorsystem.domain.alerta;

import br.com.fiap3espf.spacemonitorsystem.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Alerta")
@Table(name = "alertas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regiao;
    private String descricao;
    private String nivelRisco;
    private LocalDateTime dataDeteccao;
    private String intensidade;

    @Enumerated(EnumType.STRING)
    private TipoQueimada tipoQueimada;

    @Embedded
    private Endereco endereco;
    private boolean ativo = true;

    public Alerta(DadosCadastroAlerta dados) {
        this.regiao = dados.regiao();
        this.descricao = dados.descricao();
        this.nivelRisco = dados.nivelRisco();
        this.intensidade = dados.intensidade();
        this.dataDeteccao = dados.dataDeteccao();
        this.tipoQueimada = dados.tipoQueimada();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoAlerta dados) {

        if (dados.regiao() != null && !dados.regiao().isBlank()) {
            this.regiao = dados.regiao();
        }

        if (dados.descricao() != null && !dados.descricao().isBlank()) {
            this.descricao = dados.descricao();
        }

        if (dados.nivelRisco() != null && !dados.nivelRisco().isBlank()) {
            this.nivelRisco = dados.nivelRisco();
        }

        if (dados.intensidade() != null && !dados.intensidade().isBlank()) {
            this.intensidade = dados.intensidade();
        }

        if (dados.dataDeteccao() != null) {
            this.dataDeteccao = dados.dataDeteccao();
        }

        if (dados.tipoQueimada() != null) {
            this.tipoQueimada = dados.tipoQueimada();
        }

        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
