public class book {
    String isbn;
    String title;
    String genre;
    String publisher;
    int copy;
    int price;
    
    book(String isbn, String title, String genre, String publisher, String copy, String price ){
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.copy = Integer.parseInt(copy);
        this.price = Integer.parseInt(price);
    }
    
    String getISBN(){
        return isbn;
    }
    String getTitle(){
        return title;
    }
    String getGenre(){
        return genre;
    }
    String getPublisher(){
        return publisher;
    }
    int getCopy(){
        return copy;
    }
    int getPrice(){
        return price;
    }
    
    void updatePrice(String n){
        this.price = Integer.parseInt(n);
    }
    void updateCopy(String n){
        this.copy = Integer.parseInt(n);
    }
    String getStatus(){
        if(this.copy >0) return " READY";
        else return "NOT READY";
                
    }
    @Override
    public String toString(){
        return isbn + "\n"
                + title + "\n"
                + genre + "\n"
                + publisher + "\n"
                + copy + "\n"
                + price + "\n"
                + getStatus()
                ;
    }
}