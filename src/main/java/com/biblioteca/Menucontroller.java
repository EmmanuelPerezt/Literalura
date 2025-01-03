package com.biblioteca;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Menucontroller implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        var scanner = new Scanner(System.in);
        

        options.showMenu();
        System.out.println("Ingrese una opción: ");
        var option = scanner.nextInt();
        var request = new Httprequestcontroller();
        String res = request.sendRequest("https://gutendex.com/books/");
        System.out.println(res);
        scanner.close();
    }
    
}




class  options {
    private final static String menu = """
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


    
}
