public class Library {
  private Book[] books; // constructor add
  private Librarian librarian;

  public Library() {
    this.books = new Book[0]; 
  }

  public Librarian getLibrarian() {
    return this.librarian;
  }

  public void add(Book book) {
    Book[] newBooks = new Book[this.books.length + 1];
    for (int i = 0; i < this.books.length; i++) {
      newBooks[i] = books[i];
    }
    newBooks[newBooks.length - 1] = book;
    this.books = newBooks;
  }

  public static void main(String[] args) {
    Library library = new Library();
    library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
    library.add(new Book("To Kill a Mockingbird", "Harper Lee"));
}
}