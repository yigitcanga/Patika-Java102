package BookOrder;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        TreeSet<Book> books=new TreeSet<Book>();

        Book b1=new Book("Küçük Prens",302,"Antoine de Saint-Exupéry",2020);
        Book b2=new Book("Simşek Hırsızı",350,"Rick Riordan",2021);
        Book b3=new Book("Yüzük Kardeşliği",105,"J.R.R. Tolkien",2022);
        Book b4=new Book("Taht Oyunları",850,"George Martin",2014);
        Book b5=new Book("Son Dilek",120,"Andrej Sapkowski",2020);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);

        System.out.println("Ada göre sıralama : ");
        for(Book book:books){

            System.out.println("Kitap Adı : "+book.getName()+
                    ",\t Sayfa Sayısı : "+book.getTotalPage()+
                    ",\t Yazarın İsmi : "+book.getAuthor()+
                    ",\t Yayın Tarihi : "+ book.getPublishYear());
        }

        //kitap sayfasına göre sıralama.
        TreeSet<Book> books2=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTotalPage() - o2.getTotalPage();
            }
        });
        books2.add(b1);
        books2.add(b2);
        books2.add(b3);
        books2.add(b4);
        books2.add(b5);
        System.out.println("----------------------------------");
        System.out.println("Sayfa sayısına göre sıralama :");
        for (Book book:books2) {
            System.out.println("Kitap adı : " + book.getName() +
                    ",\t Sayfa Sayısı : " + book.getTotalPage() +
                    ",\t Yazarın İsmi : " + book.getAuthor() +
                    ",\t Yayın Tarihi : " + book.getPublishYear());
        }
    }
}
