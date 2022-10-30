package BookList;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Yüzüklerin Efendisi Kralın Dönüşü", 428, "J.R.R. Tolkien", 1955));
        bookList.add(new Book("Harry Potter ve Sırlar Odası", 314, "J.K. Rowling", 1998));
        bookList.add(new Book("Şimşek Hırsızı", 364, "Rick Riordan", 2005));
        bookList.add(new Book("Hayvan Çiftliği", 152, "George Orwell", 1945));
        bookList.add(new Book("Otomatik Portakal", 171, "Anthony Burgess", 1962));
        bookList.add(new Book("Açlık Oyunları", 384, "Suzanne Collins", 2008));
        bookList.add(new Book("Son Dilek", 400, "Andrzej Sapkowski", 1993));
        bookList.add(new Book("Kara Kule", 239, "Stephen King", 1982));
        bookList.add(new Book("Taht Oyunları", 850, "George R.R. Martin", 1996));
        bookList.add(new Book("Momo", 119, "Ende", 1980));

        System.out.println("--------------------------------------");
        Map<String, String> bookMap = new HashMap<>();
        bookList.stream().forEach(book -> bookMap.put(book.getName(), book.getAuthor()));
        for (String i : bookMap.keySet()) {
            System.out.println("Book: " + i + "\nAuthor: " + bookMap.get(i));
        }
        System.out.println("--------------------------------------");
        // filter
        List<Book> listBook = bookList.stream().filter(book -> book.getNumber() > 100).collect(Collectors.toList());
        listBook.stream().forEach(b -> System.out.println("Book name : " + b.getName() + "  " +
                "Page Number: " + b.getNumber() + "  " +
                "Author: " + b.getAuthor() + "  " +
                "ReleaseDate: " + b.getReleaseDate()));

        System.out.println("--------------------------------------");

        long count = bookList.stream().count();
        System.out.println("Number of books: " + count);

    }
}