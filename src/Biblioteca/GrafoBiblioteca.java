/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

import java.util.*;

/**
 *
 * @author nefor
 */
class GrafoBiblioteca {
    
    private final Map<String, Set<String>> relaciones;

    public GrafoBiblioteca(){
        relaciones = new HashMap<>();
    }
    
    public void agregarRelacion (String usuario, String libro){
        relaciones.putIfAbsent(usuario, new HashSet<>());
        relaciones.get(usuario).add(libro);
    }
    
    public void eliminarRelacion (String usuario, String libro){
        if(relaciones.containsKey(usuario)) relaciones.get(usuario).remove(libro);
    }
    
    public void listarRelaciones(){
        relaciones.forEach((usuario,libros) -> {
            System.out.println("Usuario: "+usuario+" Libros: "+libros);
            });
    }
    
}
