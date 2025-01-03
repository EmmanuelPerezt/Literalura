package com.biblioteca;

import java.io.IOException;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Menucontroller implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {


        var scanner = new Scanner(System.in);
        int option;
        var opts= new options();
        do {
            
            options.showMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    opts.option1();
                    break;
                case 2:
                    System.out.println("Buscar libro");
                    break;
                case 3:
                    System.out.println("Agregar libro");
                    break;
                case 4:
                    System.out.println("Actualizar libro");
                    break;
                case 5:
                    System.out.println("Eliminar libro");
                    break;
                case 6:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            
        } while (option != 6);
        scanner.close();
    }


    
}




class  options {
    private final static String menu = """
        Ingresa una opción:
        1. Listar libros
        2. Buscar libro
        3. Agregar libro
        4. Actualizar libro
        5. Eliminar libro
        6. Salir
                """;
    
    
        public static void showMenu() {
            System.out.println(menu);
    }


    public void option1() throws IOException, InterruptedException {
        System.out.println("Listar libros");
        var request = new Httprequestcontroller();
        String res = request.sendRequest("https://gutendex.com/books/");
        System.out.println(res);
    }
    public void option2() {
        System.out.println("Buscar libro");
    }
    public void option3() {
        System.out.println("Agregar libro");
    }
    public void option4() {
        System.out.println("Actualizar libro");
    }
    public void option5() {
        System.out.println("Eliminar libro");
    }
    public void option6() {
        System.out.println("Salir");
    }



    
}
