package BookOrder;

public class Book implements Comparable<Book>{

    private String name;
    private int totalPage;
    private String author;
    private int publishYear;

    public Book(String name, int totalPage, String author, int publishYear) {
        this.name = name;
        this.totalPage = totalPage;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public int getTotalPage() {
        return totalPage;
    }


    public String getAuthor() {
        return author;
    }


    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public int compareTo(Book b) {
        return getName().compareTo(b.getName());
    }
}
