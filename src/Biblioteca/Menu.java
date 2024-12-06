/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

import java.util.Scanner;

/**
 *
 * @author nefor
 */
public class Menu {
    
    public final Scanner entrada;
    
    public Menu(){
        this.entrada = new Scanner(System.in);
    }
    
    public void mostrarMenuPrincipal(){
        System.out.println("1. Menu Libros");
        System.out.println("2. Menu Usuarios");
        System.out.println("3. Gestionar Relaciones");
        System.out.println("4. Salir");
    }
    
    public int leeropcion(){
        System.out.println("Ingrese una opción");
        try {
            return Integer.parseInt(entrada.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número valido");
            return -1;
        }
    }
    
    
    public void mostrarMenuLibros(){
        System.out.println("-----Menu Libros-----");
        System.out.println("1. Agregar Libros");
        System.out.println("2. Listar Libros");
        System.out.println("3. Volver");
    }
    
    public void mostrarMenuusuarios() {
        System.out.println("-----Menu Usuarios-----");
        System.out.println("1. Agregar Usuarios");
        System.out.println("2. Listar Usuarios");
        System.out.println("3. Volver");
    }

    public void mostrarMenurelaciones() {
        System.out.println("-----Menu Relaciones-----");
        System.out.println("1. Agregar Relaciones");
        System.out.println("2. Eliminar Relaciones");
        System.out.println("3. Listar Relaciones");
        System.out.println("4. Volver");
    }
    
}
