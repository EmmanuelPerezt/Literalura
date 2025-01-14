package com.biblioteca;

import java.io.IOException;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class Menucontroller implements CommandLineRunner {
    //

    private final options opts;

    //debemos llamar a la clase options para poder acceder a sus metodos mediante spring
    public Menucontroller(options opts){
        this.opts = opts;
    }

    @Override
    public void run(String... args) throws Exception {
        var scanner = new Scanner(System.in);
        int option;
        do {
            options.showMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    opts.option1();
                    break;
                case 2:
                scanner.nextLine();
                System.out.println("cual es el titulo del libro que deseas buscar?\n");
                String title = scanner.nextLine();
                System.out.println("buscamos un libro con el titulo: " + title);
                opts.option2(title);
                    break;
                case 3:
                scanner.nextLine();
                System.out.println("cual es el autor del libro que deseas buscar?\n");
                String author = scanner.nextLine();
                System.out.println("buscamos un libro con el autor: " + author);
                opts.option3(author);
                    break;
                case 4:
                scanner.nextLine();
                System.out.println("buscar por lenguaje\n");
                String lenguage = scanner.nextLine();
                System.out.println("buscamos un libro con el lenguaje: " + lenguage);
                opts.option4(lenguage);
                    break;
                case 5:
                    opts.option5();
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



@Component
class  options {

    //inyectar repositorios
    private final DataAddedService dataAddedService;
    public options(DataAddedService dataAddedService) {
        this.dataAddedService = dataAddedService;

    }
    private final static String menu = """
        Ingresa una opción:
        1. Agregar libros a la base de datos
        2. Buscar libro por titulo
        3. buscar libro por autor
        4. buscar por lenguaje
        5. eliminar toda la base de datos
        6. Salir
                """;
    
    
        public static void showMenu() {
            System.out.println(menu);
    }


    public void option1() throws IOException, InterruptedException {
        dataAddedService.addData();
    }
    public void option2(String title) {
        dataAddedService.findbyTitle(title);
    }
    public void option3(String author) {
        dataAddedService.findByauthor(author);
    }
    public void option4(String lenguage) {
        dataAddedService.findBylanguage(lenguage);
    }
    public void option5() {
        dataAddedService.deleteAll();
    }
    public void option6() {
        System.out.println("Salir");
    }

}
