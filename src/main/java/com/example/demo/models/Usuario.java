package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long User_id;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Contrasenna;
    private Boolean Admin;

    

    public Usuario(){}

    public Usuario( String nombre, String apellido, String email, String contrasenna, Boolean Admin) {
        
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Contrasenna = contrasenna;
        this.Admin = Admin;
    }

    public Usuario(long user_id, String nombre, String apellido, String email, String contrasenna, Boolean Admin) {
        User_id = user_id;
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Contrasenna = contrasenna;
        this.Admin = Admin;
    }

    public long getUser_id() {
        return User_id;
    }
    public void setUser_id(int user_id) {
        User_id = user_id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getContrasenna() {
        return Contrasenna;
    }
    public void setContrasenna(String contrasenna) {
        Contrasenna = contrasenna;
    }
    
    public Boolean getAdmin() {
        return Admin;
    }

    public void setAdmin(Boolean admin) {
        Admin = admin;
    }
    
    
}