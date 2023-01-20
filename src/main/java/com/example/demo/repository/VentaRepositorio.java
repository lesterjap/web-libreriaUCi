package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Venta;

public interface VentaRepositorio extends JpaRepository<Venta, Long> {
    
}
