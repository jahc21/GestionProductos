package com.gestionproductos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "ordenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long idOrden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nit_empresa", nullable = false)
    private Empresa empresa;

    @Column(name = "fecha_orden", nullable = false)
    private LocalDateTime fechaOrden;

    @Column(name = "total", nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "orden_producto",
            joinColumns = @JoinColumn(name = "id_orden"),
            inverseJoinColumns = @JoinColumn(name = "codigo_producto")
    )
    private Set<Producto> productos;

    @PrePersist
    protected void onCreate() {
        fechaOrden = LocalDateTime.now();
        estado = "PENDIENTE";
    }

}
