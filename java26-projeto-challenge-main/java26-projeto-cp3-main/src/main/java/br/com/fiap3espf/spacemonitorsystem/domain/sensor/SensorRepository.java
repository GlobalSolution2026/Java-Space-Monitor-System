package br.com.fiap3espf.spacemonitorsystem.domain.sensor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Page<Sensor> findAllByAtivoTrue(Pageable paginacao);
}