/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

/**
 *
 * @author nefor
 */
public class Main {
    
    public static void main(String[] args) {

        Menu menu = new Menu();
        AVLTree<String> libros = new AVLTree<>();
        AVLTree<String> usuarios = new AVLTree<>();
        GrafoBiblioteca grafo = new GrafoBiblioteca();

        boolean salir = false;
        while (!salir) {
            menu.mostrarMenuPrincipal();
            int opcion = menu.leeropcion();
            
            switch (opcion) {
                case 1 -> manejarMenuLibros(menu, libros);
                case 2 -> manejarMenuUsuarios(menu, usuarios);
                case 3 -> manejarMenuRealaciones(menu, grafo, libros, usuarios);
                case 4 -> {
                    salir = true;
                    System.out.println("Hasta pronto");
                }
                default -> System.out.println("Opcion no valida");
            }
            
        }
    }

    private static void manejarMenuLibros (Menu menu, AVLTree<String> libros){
        boolean salir = false;
        while (!salir) {            
            menu.mostrarMenuLibros();
            int opcion = menu.leeropcion();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el código del libro");
                    String codigo = menu.entrada.nextLine();
                    System.out.println("Ingrese el código del Titulo");
                    String titulo = menu.entrada.nextLine();
                    System.out.println("Ingrese el código del Autor");
                    String autor = menu.entrada.nextLine();
                    libros.insertar(codigo, new Libro(codigo,titulo,autor));
                    System.out.println("Libro guardado con Exito ");
                }
                case 2 -> {
                    System.out.println("Lista de libros");
                    libros.recorridoInOrden();
                } 
                case 3 -> {
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
    
    
    private static void manejarMenuUsuarios (Menu menu, AVLTree<String> usuarios){
         boolean salir = false;
        while (!salir) {            
            menu.mostrarMenuusuarios();
            int opcion = menu.leeropcion();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la identifiación del usuario");
                    String cedula = menu.entrada.nextLine();
                    System.out.println("Ingrese el nombre del usuario");
                    String nombre = menu.entrada.nextLine();
                    System.out.println("Ingrese el apellido del usuario");
                    String apellido = menu.entrada.nextLine();
                    usuarios.insertar(cedula, new Usuario(cedula, nombre, apellido));
                    System.out.println("Usuario guardado con Exito ");
                }
                case 2 -> {
                    System.out.println("Lista de Usuarios");
                    usuarios.recorridoInOrden();
                } 
                case 3 -> {
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
    
    
    private static void manejarMenuRealaciones (Menu menu, GrafoBiblioteca grafo, AVLTree<String> libros, AVLTree<String> usuarios){
        boolean salir = false;
        while (!salir) {            
            menu.mostrarMenurelaciones();
            int opcion = menu.leeropcion();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la identifiación del usuario");
                    String cedula = menu.entrada.nextLine();
                    System.out.println("Ingrese el codigo del libro");
                    String codigo = menu.entrada.nextLine();
                    
                    if(usuarios.buscar(cedula)!= null && libros.buscar(codigo) != null){
                        grafo.agregarRelacion(codigo, codigo);
                        System.out.println("Relación Agregada con exito");
                    }else{
                        System.out.println("Usuario no encontrado");
                    }
                }
                case 2 -> {
                    System.out.println("Ingrese la identifiación del usuario");
                    String cedula = menu.entrada.nextLine();
                    System.out.println("Ingrese el codigo del libro");
                    String codigo = menu.entrada.nextLine();
                    
                    if(usuarios.buscar(cedula)!= null && libros.buscar(codigo) != null){
                        grafo.eliminarRelacion(codigo, codigo);
                        System.out.println("Relación eliminada con exito");
                    }
                }
                case 3 -> {
                    System.out.println("-----Lista de relaciones-----");
                    grafo.listarRelaciones();
                }
                case 4 -> {
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
    
    
    
}
