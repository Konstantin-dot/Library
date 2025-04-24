package library;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Попытка загрузить библиотеку из файла
        library.loadFromFile("library.txt");

        while (true) {
            System.out.println("Список методов для управления библиотекой:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Найти книгу");
            System.out.println("4. Показать все книги");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора книги: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите год издания: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Введите жанр книги: ");
                    String genre = scanner.nextLine();
                    try {
                        Book book = new Book(title, author, year, genre);
                        library.addBook(book);
                        System.out.println("Книга добавлена.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Введите название книги для удаления: ");
                    String titleToRemove = scanner.nextLine();
                    if (titleToRemove.trim().isEmpty()) {
                        System.out.println("Ошибка: Название книги не может быть пустым.");
                    } else {
                        library.removeBook(titleToRemove);
                        System.out.println("Книга удалена");
                    }
                    break;

                case 3:
                    System.out.print("Введите название книги для поиска: ");
                    String titleToFind = scanner.nextLine();
                    Book foundBook = library.findBook(titleToFind);
                    if (foundBook != null) {
                        System.out.println("Книга найдена: " + foundBook);
                    } else {
                        System.out.println("Книга не найдена.");
                    }
                    break;

                case 4:

                    System.out.println("Список всех книг:");
                    library.printAllBooks();
                    break;

                case 5:
                    try {
                        library.saveToFile("library.txt");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
