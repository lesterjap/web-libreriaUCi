package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuariosRepositorio;



@Service
public class ServicioUsuario{

    @Autowired
    private UsuariosRepositorio SU;

  
    public List<Usuario> ListarUsuario(){
        List<Usuario> Lista = SU.findAll();
        return Lista;
    }
   

    public int GuardarUsuario(Usuario U){
        SU.save(U);
      return 1;
    }
    
    /**
     * @param Id
     * @return
     */
    public int eliminarUsuario(Long Id){
      SU.deleteById(Id);   
    return 1;
    }
    
    public int update(Usuario U, String LiID){
        Usuario aux = SU.getReferenceById(Long.parseLong(LiID));
        if(U.getNombre().isEmpty()){
            U.setNombre(aux.getNombre());
        }
        if(U.getApellido().isEmpty()){
            U.setApellido(aux.getApellido());
        }
        if(U.getEmail().isEmpty()){
            U.setEmail(aux.getEmail());
        }
        if(U.getContrasenna().isEmpty()){
            U.setContrasenna(aux.getContrasenna());
        }
        
          
        SU.deleteById(Long.parseLong(LiID));
        SU.save(U);

        return 1;
    }


    
}

