import java.util.Deque;
import java.util.LinkedList;

public class Browser {
  
  private Deque<String> backHistories;
  private Deque<String> forwardHistories;
  private String currentPage;

  public Browser() {
    this.backHistories = new LinkedList<>();
    this.forwardHistories = new LinkedList<>();
    this.currentPage = null;
  }

  public void browse(String url){
    if (this.currentPage != null){
    this.backHistories.addLast(this.currentPage);
    }
    this.currentPage = url;
    forwardHistories.clear();
  }

  public String back() {
    if (this.backHistories.isEmpty()) {
      return "No Previous Page";
    } else {
      this.forwardHistories.addFirst(this.currentPage);
      this.currentPage = this.backHistories.pollLast();
      
      return this.currentPage;
    }
  }

  public String forward() {
    if (this.forwardHistories.isEmpty()) {
      return "No next page";
    } else {
      this.backHistories.addLast(this.currentPage);
      this.currentPage = this.forwardHistories.pollFirst();
      return this.currentPage;
    }
  }

  public static void main(String[] args) {
    Browser browser = new Browser();
    browser.browse("youtube.com");
    browser.browse("google.com");
    System.out.println(browser.back());
    System.out.println(browser.forward());
    System.out.println(browser.back());
    browser.browse("github.com");
  }
}


// use 1 queue to do?