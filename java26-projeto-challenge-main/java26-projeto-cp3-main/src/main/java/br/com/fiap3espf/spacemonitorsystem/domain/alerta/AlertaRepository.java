package br.com.fiap3espf.spacemonitorsystem.domain.alerta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    Page<Alerta> findAllByAtivoTrue(Pageable paginacao);
}
