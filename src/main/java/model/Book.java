package model;

public class Book implements Cloneable {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private float price;

    public Book() {
        id = 0;
        title = author = publisher = "";
        price = 0f;
    }

    public Book(int id, String title, String author, String publisher, float price) {
        this();
        if (id > 0) this.id = id;
        if (title != null) this.title = title;
        if (author != null) this.author = author;
        if (publisher != null) this.publisher = publisher;
        if (price > 0) this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", author, title, publisher);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (other instanceof Book) {
            Book otherBook = (Book) other;
            if (title.equalsIgnoreCase(otherBook.title)
                && author.equalsIgnoreCase(otherBook.author)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Object clone() {
        return new Book(id, title, author, publisher, price);
    }

    public boolean isTrash() {
        return id == 0 || price == 0 || title.equals("")
                || author.equals("") || publisher.equals("");
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public float getPrice() {
        return price;
    }
}
