package com.example.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Usuario;






@SpringBootTest
public class ServicioUsuarioTest {
    
    @Autowired
    ServicioUsuario SU;
    
    
    @Test
    void testGuardarUsuario() {
            Usuario Usuario = new Usuario("Lester", "Alzugaray", "lestervaradero@gmail.com", "Lap990202029009+", true);
            int aux = SU.GuardarUsuario(Usuario);
            assertEquals(1, aux);
    }

    @Test
    void testListarUsuario() {
        assertNotNull(SU.ListarUsuario());
    }

    @Test
    void testEliminarUsuario() {
        int aux = SU.eliminarUsuario(SU.ListarUsuario().get(0).getUser_id());
        assertEquals(1, aux);
    }

    @Test
    void testUpdate() {
        Usuario Usuario = new Usuario("Lester", "Alzugaray", "lestervaradero@gmail.com", "Lap990202029009+", true);
       
       
       
        int aux = SU.GuardarUsuario(Usuario);
        
        assertEquals(1, aux);
        
    }
}
