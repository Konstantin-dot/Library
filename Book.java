package library;
// Класс книг
public class Book {

    private String title;
    private String author;
    private int year;
    private String genre;

    // Конструктор
    public Book(String title, String author, int year, String genre) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() ||
                genre == null || genre.trim().isEmpty() || year <= 0) {
            throw new IllegalArgumentException("Все поля должны быть заполнены корректно, а год не может быть отрицательным или нулевым.");
        }

        this.title = title; // Название книги
        this.author = author; // Автор книги
        this.year = year; // Год издания
        this.genre = genre; // Жанр книги
    }

    // Геттеры и сеттеры
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Название: "+title+", Автор: "+author+", Год издания: "+year+", Жанр: "+genre;
    }
}
