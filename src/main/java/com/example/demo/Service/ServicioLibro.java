package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.LibroRepositorio;
import com.example.demo.models.Libro;



@Service
public class ServicioLibro {

    @Autowired
    private LibroRepositorio LR;

  
    public List<Libro> ListarLibro(){
        List<Libro> Lista = LR.findAll();
        return Lista;
    }
   

    public int GuardarLibro(Libro l){
        LR.save(l);
      return 1;
    }
    
    /**
     * @param Id
     * @return
     */
    public int eliminarLibro(Long Id){
      LR.deleteById(Id);   
    return 1;
    }
    
    public int update(Libro l, String LiID){
        Libro aux = LR.getReferenceById(Long.parseLong(LiID));
        if(l.getAutor().isEmpty()){
            l.setAutor(aux.getAutor());
        }
        if(l.getISBN().isEmpty()){
            l.setISBN(aux.getISBN());
        }
        if(l.getNombreLibro().isEmpty()){
            l.setNombreLibro(aux.getNombreLibro());
        }
        if(l.getPais().isEmpty()){
            l.setPais(aux.getPais());
        }
        if(l.getPrecio() == 0.0){
            l.setPrecio(aux.getPrecio());
        }
        if(l.getdescrp().isEmpty()){
            l.setdescrp(aux.getAutor());
        }
          
        LR.deleteById(Long.parseLong(LiID));
        LR.save(l);

        return 1;
    }


    
}
