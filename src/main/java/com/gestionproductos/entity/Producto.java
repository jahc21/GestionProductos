package com.gestionproductos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @Column(name = "codigo", length = 50)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "caracteristicas", nullable = false, columnDefinition = "TEXT")
    private String caracteristicas;

    @Column(name = "precio_usd", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUSD;

    @Column(name = "precio_eur", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioEUR;

    @Column(name = "precio_cop", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioCOP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nit_empresa", nullable = false)
    private Empresa empresa;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "codigo_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private Set<Categoria> categorias;

    @ManyToMany(mappedBy = "productos")
    private Set<Orden> ordenes;

}
