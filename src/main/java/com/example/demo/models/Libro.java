package com.example.demo.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Libro_id;

    private String NombreLibro;
    private String Pais;
    private String ISBN;
    private float precio;
    private String descrp;
    private String Autor;
   
    

    public Libro(){}

    public Libro(String nombreLibro, String pais, String iSBN, float precio,  String descrp, String Autor ) {
        NombreLibro = nombreLibro;
        Pais = pais;
        ISBN = iSBN;
        this.Autor = Autor;
        this.descrp = descrp;
        this.precio = precio;
        
    }
    
    public Libro(long libro_id, String nombreLibro, String pais, String iSBN, float precio,String descrips, String Autor) {
        Libro_id = libro_id;
        NombreLibro = nombreLibro;
        Pais = pais;
        ISBN = iSBN;
        this.precio = precio;
        this.descrp = descrips;
        this.Autor = Autor;
    }
    public long getLibro_id() {
        return Libro_id;
    }
    public void setLibro_id(long libro_id) {
        Libro_id = libro_id;
    }
    public String getNombreLibro() {
        return NombreLibro;
    }
    public void setNombreLibro(String nombreLibro) {
        NombreLibro = nombreLibro;
    }
    public String getPais() {
        return Pais;
    }
    public void setPais(String pais) {
        Pais = pais;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

 
    
    public String getdescrp() {
        return descrp;
    }

    public void setdescrp(String descrp) {
        this.descrp = descrp;
    }
    

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
}
