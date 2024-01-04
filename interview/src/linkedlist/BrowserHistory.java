/**
 * @author akhilpathivada
 * <p>
 * date : 04/01/24
 * time: 05:29
 *
 * https://leetcode.com/problems/design-browser-history/description/
 * 
 */
package linkedlist;

public class BrowserHistory {

    private final class DoubleLinkedListNode {

        private final String url;

        private DoubleLinkedListNode prev;

        private DoubleLinkedListNode next;

        private DoubleLinkedListNode(String url) {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }

    private DoubleLinkedListNode head;

    private DoubleLinkedListNode tail;

    private DoubleLinkedListNode currentPage; // the current page

    public BrowserHistory(String homepage) {
        head = new DoubleLinkedListNode(homepage);
        tail = head;
        currentPage = head;
    }

    public void visit(String url) {
        DoubleLinkedListNode newPage = new DoubleLinkedListNode(url);
        currentPage.next = newPage;
        newPage.prev = currentPage;
        tail = currentPage = newPage;
    }

    public String back(int steps) {
        while (steps-- > 0) {
            if (currentPage == head) {
                return currentPage.url;
            }
            currentPage = currentPage.prev;
        }
        return currentPage.url;
    }

    public String forward(int steps) {
        while (steps-- > 0) {
            if (currentPage == tail) {
                return currentPage.url;
            }
            currentPage = currentPage.next;
        }
        return currentPage.url;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   // You are in "google.com", you can move back only one
    }
}
