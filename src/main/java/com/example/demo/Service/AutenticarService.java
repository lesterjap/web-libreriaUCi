package com.example.demo.Service;

import java.util.List;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UsuariosRepositorio;

@Service
public class AutenticarService {
     private long ID = 0;
    @Autowired
    private UsuariosRepositorio UsuarioR;

    public boolean autenticar(String gmail, String password){

        List<Usuario> Lista = UsuarioR.findAll();
        for(Usuario U: Lista){
            if (U.getEmail().equals(gmail)){
                 if(U.getContrasenna().equals(password)){
                    return true;   
                 }  
            }
        }
        
        return false;
    }

    public boolean crearUsuario(String Nombre, String gmail, String contrasenna, String Apellido, Boolean Admin){
        try{
        Usuario u = new Usuario(ID,Nombre, Apellido, gmail, contrasenna,Admin);
        UsuarioR.save(u);
        ID++;
        return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
