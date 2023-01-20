
package com.example.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Venta;
import com.example.demo.repository.UsuariosRepositorio;
import com.example.demo.repository.VentaRepositorio;




@SpringBootTest
public class ServicioVentaTest {

    @Autowired
    ServicioVenta SV;

    @Autowired
    VentaRepositorio VR;

    @Autowired
    ServicioUsuario SU;
    UsuariosRepositorio UR;

    @Test
    void testComprar() {
        Venta Venta = new Venta(4, (float) 32.3, "Date", SU.ListarUsuario().get(0).getUser_id());

       int aux = SV.Comprar(Venta);

       assertEquals(1, aux);

    }

    @Test
    void testEliminarVenta() {
        int aux = SV.EliminarVenta(SV.listarVentas().get(0).getVenta_id());
        assertEquals(1, aux);
    }

    /**
     * 
     */
    @Test
    void testListarVentas() {
        
        assertNotNull(SV.listarVentas());

        VR.deleteAll();;
        
        final List<Venta> Ventas = SV.listarVentas();

        assertEquals(true, Ventas.isEmpty());
    }
}
