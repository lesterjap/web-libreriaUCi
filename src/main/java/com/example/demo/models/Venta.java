package com.example.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Venta_id;
    private Integer Cantidad;
    private float Importe;
    private String Fecha;
    private long User_ID;


    public Venta(){}
    
    public Venta( Integer cantidad, float importe, String fecha, long user_ID) {
       
        
        Cantidad = cantidad;
        Importe = importe;
        Fecha = fecha;
        User_ID = user_ID;
    } 
   
   
   
    public Venta(long venta_id, Integer cantidad, float importe, String fecha, long user_ID) {
       
        Venta_id = venta_id;
        Cantidad = cantidad;
        Importe = importe;
        Fecha = fecha;
        User_ID = user_ID;
    }

    public long getVenta_id() {
        return Venta_id;
    }

    public void setVenta_id(long venta_id) {
        Venta_id = venta_id;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float importe) {
        Importe = importe;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public long getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(long user_ID) {
        User_ID = user_ID;
    }
    
   
    
}
