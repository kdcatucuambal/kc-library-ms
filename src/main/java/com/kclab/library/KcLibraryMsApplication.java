package com.kclab.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class KcLibraryMsApplication {


	public static void main(String[] args) {
		SpringApplication.run(KcLibraryMsApplication.class, args);
	}

    @Bean
    public CommandLineRunner menuInteractivo() {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            do {
                System.out.println("\n--- MENÚ LIBROS ---");
                System.out.println("1. Crear libro");
                System.out.println("2. Buscar libro por ID");
                System.out.println("3. Listar todos los libros");
                System.out.println("4. Eliminar libro por ID");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        //Libro libro = new Libro(titulo, autor);
                        //libroRepository.save(libro);
                        System.out.println("Libro creado: ");
                    }
                    case 2 -> {
                        System.out.print("ID del libro: ");
                        Long id = Long.parseLong(scanner.nextLine());
                        //Optional<Libro> libro = libroRepository.findById(id);
//                        libro.ifPresentOrElse(
//                                System.out::println,
//                                () -> System.out.println("Libro no encontrado")
//                        );
                        System.out.printf("Libro con ID %d: \n", id);
                    }
                    case 3 -> {
                        System.out.println("Lista de todos los libros:");
                        //List<Libro> libros = libroRepository.findAll();
                        //libros.forEach(System.out::println);
                    }
                    case 4 -> {
                        System.out.print("ID del libro a eliminar: ");
                        Long idEliminar = Long.parseLong(scanner.nextLine());
                        //libroRepository.deleteById(idEliminar);
                        System.out.printf("Libro con ID %d eliminado.\n", idEliminar);
                    }
                    case 5 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");
                }

            } while (opcion != 5);

            scanner.close();
        };
    }

}
