package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.VentaRepositorio;
import com.example.demo.models.Venta;


@Service
public class ServicioVenta {
    
    @Autowired VentaRepositorio RV;

    public List<Venta> listarVentas(){
        List<Venta> Lista = RV.findAll();
        return Lista;
    }
    
    public int Comprar( Venta v){
        RV.save(v);

        return 1;
    }

    public int EliminarVenta(Long id){

        RV.deleteById(id);

        return 1;
    }
}
