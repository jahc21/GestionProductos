package com.gestionproductos.repository;

import com.gestionproductos.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    List<Orden> findByClienteIdCliente(Long idCliente);
    List<Orden> findByEmpresaNit(String nit);
}
