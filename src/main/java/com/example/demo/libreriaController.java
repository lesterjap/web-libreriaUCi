
package com.example.demo; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import com.example.demo.sesion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//Elementos
import com.example.demo.Service.ServicioLibro;
import com.example.demo.Service.ServicioUsuario;
import com.example.demo.Service.ServicioVenta;
import com.example.demo.models.Libro;
import com.example.demo.models.Usuario;
import com.example.demo.models.Venta;
import com.example.demo.repository.UsuariosRepositorio;


@Controller
@RequestMapping("/")
public class libreriaController{
     List<sesion> sesiones = new LinkedList<>();
    
     @Autowired
     private ServicioLibro SL;

     @Autowired
     private ServicioUsuario SU;

     @Autowired
     private ServicioVenta RV;
     

       /**
         * @param request
         * @param Email
         * @param password
         * @param map
         * @return
         */
     @GetMapping
     public String index(HttpServletRequest request,Model map) {  
      
      Boolean esadmin = false;
      Boolean conect = false;
      Boolean conect2 = true;
      
     for(sesion s: sesiones){
         if(s.getIp().equals(request.getRemoteAddr()) ){
            esadmin = s.getU().getAdmin();
            conect = true;
            conect2 = false;
          String usuario = s.getU().getNombre();
          List<Libro> LibrosC = new LinkedList<>();
          
          List<Libro> Libros = (List<Libro>)SL.ListarLibro(); 
          for(long li:s.getLibros()){
          for(Libro l: Libros){
            l.setISBN("/portadas/"+l.getISBN()+".gif");
              if(l.getLibro_id() == li){
                LibrosC.add(l);
              } 
          }
        }
          map.addAttribute("Libros", Libros);
          map.addAttribute("Usuarioname", usuario);
          map.addAttribute("LibrosC", LibrosC);
          map.addAttribute("esadmin", esadmin);
          map.addAttribute("conect", conect);
          map.addAttribute("conect2", conect2);
          return "index";



         }

      }
      List<Libro> LibrosC = new LinkedList<>();
      List<Libro> Libros = (List<Libro>)SL.ListarLibro(); 
      for(Libro l: Libros){
        l.setISBN("/portadas/"+l.getISBN()+".gif");}
      map.addAttribute("Libros", Libros);
      map.addAttribute("Usuarioname", "Registar para comprar");
      map.addAttribute("LibrosC", LibrosC);
      map.addAttribute("conect", conect);
      map.addAttribute("conect2", conect2);

       return "index";
     }



     @PostMapping("buscarLibrosIndex/") //Buscar Libro/////////////////////////////////////////////////////////////////////////////////////
     public String buscarLibrosIndice(HttpServletRequest request,@RequestParam String text, Model map){
       List<Libro> L = (List<Libro>)SL.ListarLibro(); 
       List<Libro> Libros = new LinkedList<>();
      // int aux = 0;
       for(Libro l: L){
          if (l.getNombreLibro().contains(text)){
           
           Libros.add(l);
          } else{
        
          }
         // aux++;
       }
      
 
       map.addAttribute("Libros", Libros);
      
 
          /////////////////////////////////////////////////////////////////////////////////////////////////////



          Boolean esadmin = false;
          Boolean conect = false;
          Boolean conect2 = true;
          
         for(sesion s: sesiones){
             if(s.getIp().equals(request.getRemoteAddr()) ){
                esadmin = s.getU().getAdmin();
                conect = true;
                conect2 = false;
              String usuario = s.getU().getNombre();
              List<Libro> LibrosC = new LinkedList<>();
              
              
              for(long li:s.getLibros()){
              for(Libro l: Libros){
                l.setISBN("/portadas/"+l.getISBN()+".gif");
                  if(l.getLibro_id() == li){
                    LibrosC.add(l);
                  } 
              }
            }
              map.addAttribute("Libros", Libros);
              map.addAttribute("Usuarioname", usuario);
              map.addAttribute("LibrosC", LibrosC);
              map.addAttribute("esadmin", esadmin);
              map.addAttribute("conect", conect);
              map.addAttribute("conect2", conect2);
              return "index";
    
    
    
             }
    
          }
          List<Libro> LibrosC = new LinkedList<>();
   
          for(Libro l: Libros){
            l.setISBN("/portadas/"+l.getISBN()+".gif");
          }

          map.addAttribute("Libros", Libros);
          map.addAttribute("Usuarioname", "Registar para comprar");
          map.addAttribute("LibrosC", LibrosC);
          map.addAttribute("conect", conect);
          map.addAttribute("conect2", conect2);
    
           return "index";

      
       
        ////////////////////////////////////////////////////////////////////////////////////////////////////
         }
 
         @GetMapping("buscarLibrosIndex/")    //Para retornar a la pagina index /////////////////////////////////////////////////////////////
         public String buscarLibrosIndex(Model map){
 
           return "redirect:/";
         }
 

       //Gestionar Libros ////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("gestionarLibros/")
    public String gestionarLibros(Model map){
      List<Libro> Libros = (List<Libro>)SL.ListarLibro(); 
     
      map.addAttribute("Libros", Libros);
      map.addAttribute("Libro", new Libro());

         return "gestionarLibros";
        }

        
    @PostMapping("gestionarLibros/")
    public String GuardarLibro(@Validated Libro L, Model mp){
        SL.GuardarLibro(L);
        return  "redirect:/gestionarLibros/";
    }
    @PostMapping("eliminarL/") //Eliminar Libro
    public String eliminarLibros( @RequestParam List<String> deleteL, Model mp){
      for(String st: deleteL){
      Long id = Long.parseLong(st);
      SL.eliminarLibro(id);
      }
      return  "redirect:/gestionarLibros/";
    }
    
    @PostMapping("ModificarLibros/") //Modificar Libro
    public String modificarLibros(@Validated Libro L, @RequestParam String LiID, Model mp){
      
      SL.update(L, LiID);
      return  "redirect:/gestionarLibros/";
    }

    /**
     * @param map
     * @return
     */

    @PostMapping("buscarLibros/") //Buscar Libro
    public String buscarLibros(@RequestParam String text, Model map){
      List<Libro> L = (List<Libro>)SL.ListarLibro(); 
      List<Libro> Libros = new LinkedList<>();
     // int aux = 0;
      for(Libro l: L){
         if (l.getNombreLibro().contains(text)){
          
          Libros.add(l);
         } else{
       
         }
        // aux++;
      }
     

      map.addAttribute("Libros", Libros);
      map.addAttribute("Libro", new Libro());

         return "gestionarLibros";
        }

        @GetMapping("buscarLibros/")    //Para retornar a la pagina
        public String buscarLibros(Model map){

          return "redirect:/gestionarLibros/";
        }



      


      
        //Administrar Usuario ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
    @GetMapping("AdministrarUsuario/")
    public String AdministrarUsuario(HttpServletRequest request,Model map){
      String ip = request.getRemoteAddr();
      for(sesion s : sesiones){
        if(s.getIp().equals(ip)){
          List<Usuario> Usuarios = (List<Usuario>)SU.ListarUsuario(); 

      map.addAttribute("Usuarios", Usuarios);
      map.addAttribute("Usuario", new Usuario());

      return "adminUsuario";
          
        }

      }
     

      return "autenticar";
      
    }
 
    @PostMapping("AdministrarUsuario/") //Adicionar Usuario
    public String GuardarUsuario(@Validated Usuario U, Model mp){
        SU.GuardarUsuario(U);
        return  "redirect:/AdministrarUsuario/";
    }


    @PostMapping("eliminarU/") //Eliminar Usuario
    public String eliminarUsuarios( @RequestParam List<String> deleteU, Model mp){
      for(String st: deleteU){
      Long id = Long.parseLong(st);
      SU.eliminarUsuario(id);
      }
      return  "redirect:/AdministrarUsuario/";
    }

    @PostMapping("ModificarUsuarios/") //Modificar Usuario
    public String modificar(@Validated Usuario U, @RequestParam String LiID, Model mp){
      
      SU.update(U, LiID);
      return  "redirect:/AdministrarUsuario/";
    }  


    @PostMapping("buscarUsuarios/") //Buscar Usuario
    public String buscarUsuarios(@RequestParam String text, Model map){
      List<Usuario> U = (List<Usuario>)SU.ListarUsuario(); 
      List<Usuario> Usuarios = new LinkedList<>();
     // int aux = 0;
      for(Usuario u: U){
         if (u.getNombre().contains(text)){
          
          Usuarios.add(u);
         } else{
       
         }
        // aux++;
      }
     

      map.addAttribute("Usuarios", Usuarios);
      map.addAttribute("Usuario", new Usuario());

         return "adminUsuario";
        }

        @GetMapping("buscarUsuarios/")    //Para retornar a la pagina
        public String buscarUsuarios(Model map){

          return "redirect:/AdministrarUsuario/";
        }

         //Administrar Cuenta/////////////////////////////////////////////////////////////////////////////////////////////

@PostMapping("Modificarme/") //Modificar Usuario
    public String modificarU(HttpServletRequest request, @Validated Usuario U, @RequestParam String LiID, Model mp){
       
      for(sesion s: sesiones){
        if(s.getIp().equals(request.getRemoteAddr()) ){
          s.setU(U);

        } 
      }



      SU.update(U, LiID);
      return  "redirect:/";
    } 

    @PostMapping("Eliminarme/") //Eliminar
    public String elmininarme( HttpServletRequest request, @RequestParam String LiID, Model mp){
      int aux = 0;
     
      for(sesion s: sesiones){
        if(s.getIp().equals(request.getRemoteAddr()) ){
          aux++;

        } 
      }
      sesiones.remove(aux);

      SU.eliminarUsuario(Long.parseLong(LiID));

      return "redirect:/Logout/";
    }

        //Administrar Ventas ////////////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * @param request
         * @param map
         * @return
         */
        @GetMapping("AdministrarVenta/")
        public String AdministrarVenta(HttpServletRequest request, Model map){
          String ip = request.getRemoteAddr();
          
          for(sesion s : sesiones){
            if(s.getIp().equals(ip)){
      
          List<Venta> Ventas = (List<Venta>)RV.listarVentas(); 
          map.addAttribute("Ventas", Ventas);
          map.addAttribute("Venta", new Venta());
    
          return "adminVentas";
            }
          }

           return "autenticar"; 
        }


        @PostMapping("eliminarV/") //Eliminar venta
        public String eliminarVenta( @RequestParam List<String> deleteV, Model mp){
          for(String st: deleteV){
          Long id = Long.parseLong(st);
          RV.EliminarVenta(id);
          }
          return  "redirect:/AdministrarVenta/";
        }


        







        //Autenticar/////////////////////////////////////////////////////////////////////////////////////////////////////

      @GetMapping("EditPerfil/")
      public String ModifiPerfil(HttpServletRequest request,Model map){
        String ip = request.getRemoteAddr();
       Usuario us = new Usuario();
        for(sesion s : sesiones){
          if(s.getIp().equals(ip)){
            us = s.getU();
            break;
          }
         }

         map.addAttribute("Usuario", us);
        return "administrarCuenta";
      }

       @GetMapping("Login/")
       public String login(){

        return "autenticar";
       }

       @GetMapping("Registrarse/")
       public String Registyrarse(Model map){
        map.addAttribute("Usuario", new Usuario());

        return "registrarU";
       }
       @PostMapping("Registrarse/")
       public String Registrarse(@Validated Usuario U,Model map){
        map.addAttribute("Usuario", new Usuario());
        SU.GuardarUsuario(U);
        return "autenticar";
       }


        /**
         * @param request
         * @param Email
         * @param password
         * @param map
         * @return
         */
        @PostMapping("Autenticar/")    ////////////////////////////////////////////////////////////////////////////
        public String autenticar(HttpServletRequest request, String Email,String password,Model map){
        
          String ip = request.getRemoteAddr();
          boolean paso = false;
          boolean paso2 = false;
        List<Usuario> Usuarios = (List<Usuario>)SU.ListarUsuario();  //comprobacion de identidad /////////
        Usuario user = new Usuario();
        for(Usuario u: Usuarios){
          if(u.getEmail().equals(Email)&& u.getContrasenna().equals(password)){
             user = u;
             paso2 = true;
             for(sesion s : sesiones){
              if(s.getIp().equals(ip)){
                paso = true;
              }
             }
             if(!paso){
             sesiones.add(new sesion(user, ip));
              }

          break;

          }
        }
       if(paso2){

        return  "redirect:/";
       }else{

        return  "redirect:/Login/";
       }
         
        }

        @GetMapping("Logout/")          /////Logout/////////////////////////////////////////////////////////////////////////////////////////////////////
        public String Logout(HttpServletRequest request){
          String ip = request.getRemoteAddr();

          for(sesion  s : sesiones){

            if(s.getIp().equals(ip)){

              sesiones.remove(s);
              break;
            }


          }
          

          return "redirect:/";
        }



        ///Compra/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Carrito/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        @PostMapping("agregarCarrito/")
        public String AgregarCarrito(HttpServletRequest request, String idL, Model map){

          for (sesion s : sesiones ){
            if(s.getIp().equals(request.getRemoteAddr())){

              s.setLibros(Long.parseLong(idL));

              break;
            }

          }

          return "redirect:/";
        }

       
       
        @GetMapping("Comprar/")            ////////Comprar///////////////////////////////////////////////////////////////////////////

      public String Compra(HttpServletRequest request){

        String ip = request.getRemoteAddr();


        for (sesion s : sesiones){

          if (s.getIp().equals(ip)){
            float importe = 0;
            LinkedList<Long> list = s.getLibros();

            

            for(long l: list){
              for(Libro L: (List<Libro>)SL.ListarLibro()){
                  
                 if(L.getLibro_id() == l){
                        importe += L.getPrecio();  
                  }
              }
            }
           
            

            java.util.Date date = new java.util.Date();
            
            

            RV.Comprar(new Venta(list.size(),importe, date+"" , s.getU().getUser_id() ));
            s.getLibros().clear();
          }


        }

        return "redirect:/";
      }


      @GetMapping("quejas/")
      public String quejas(HttpServletRequest request,Model map){
        String ip = request.getRemoteAddr();
       Usuario us = new Usuario();
        for(sesion s : sesiones){
          if(s.getIp().equals(ip)){
            us = s.getU();
            break;
          }
         }

         map.addAttribute("Usuario", us);
        return "quejasSugerencias";
      }



}