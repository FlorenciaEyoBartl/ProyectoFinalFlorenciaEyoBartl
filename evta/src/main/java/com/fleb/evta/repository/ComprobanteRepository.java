package com.fleb.evta.repository;

import com.fleb.evta.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Integer> {

}
