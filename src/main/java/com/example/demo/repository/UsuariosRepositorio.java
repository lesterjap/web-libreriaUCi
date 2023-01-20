package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Usuario;

public interface UsuariosRepositorio extends JpaRepository<Usuario, Long> {
    
}
