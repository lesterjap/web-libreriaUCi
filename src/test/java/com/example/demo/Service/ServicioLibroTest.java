
    

package com.example.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Libro;

@SpringBootTest  
public class ServicioLibroTest {

    @Autowired
    ServicioLibro SL;

    @Test
    void testGuardarLibro() {
        Libro libro = new Libro("Pais","asdsd", "sadasd",(float) 33.3,"wqeqw","weqwe");
        int aux  = SL.GuardarLibro(libro);
        assertEquals(1, aux);
    }

    @Test
    void testListarLibro() {
        SL.ListarLibro();

        assertNotNull(SL.ListarLibro());
    }

    @Test
    void testEliminarLibro() {
        int aux = SL.eliminarLibro(SL.ListarLibro().get(0).getLibro_id());
        assertEquals(1,aux);
    }

    @Test
    void testUpdate() {
        Libro libro = new Libro("100 horas de soledad","America", "sadasd",(float) 33.3,"Novela","Luis miguel");
        int aux = SL.update(libro,"chas");

        assertEquals(1, aux);
    }
}
