package com.gestionproductos.repository;

import com.gestionproductos.entity.Inventario;
import com.gestionproductos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findByProducto(Producto producto);
}
