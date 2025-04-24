package library;
// класс библиотека содержит методы для управления коллекцией
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Метод для добавления книги
    public void addBook(Book book) {
        books.add(book);
    }

    // Метод для удаления книги
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    // Метод для поиска книги по названию
    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Возвращаем null, если книга не найдена
    }

    // Метод для вывода всех книг
    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("В библиотеке нет книг.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getGenre());
                writer.newLine();
            }
            System.out.println("Библиотека успешно сохранена в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String title = parts[0];
                    String author = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    String genre = parts[3];
                    books.add(new Book(title, author, year, genre));
                }
            }
            System.out.println("Библиотека загружена из файла.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }


}
