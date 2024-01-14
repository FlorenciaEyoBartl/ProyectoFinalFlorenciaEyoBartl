package com.fleb.evta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fleb.evta.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
