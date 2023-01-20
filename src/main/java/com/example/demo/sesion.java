package com.example.demo;


import java.util.LinkedList;

import com.example.demo.models.Usuario;



public class sesion {
     Usuario u;
     String ip;
     LinkedList<Long> libros = new LinkedList<>();

    
    public sesion(Usuario u, String ip) {
       
        this.u = u;
        this.ip = ip;
    }
    public Usuario getU() {
        return u;
    }
    public void setU(Usuario u) {
        this.u = u;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public LinkedList<Long> getLibros() {
        return libros;
    }
    public void setLibros(Long Id) {
        this.libros.add(Id);
    }
    
}
