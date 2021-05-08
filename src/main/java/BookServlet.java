import service.BasicBookService;
import service.BookService;
import model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    private static BookService bookService = new BasicBookService();

    private static final String JSP_ALL = "book-all.jsp";
    private static final String JSP_SEARCH = "book-search.jsp";
    private static final String JSP_CREATE = "book-create.jsp";
    private static final String JSP_EDIT = "book-edit.jsp";
    private static final String JSP_DELETE = "book-delete.jsp";
    private static final String JSP_RESULT = "book-result.jsp";
    private static final String JSP_ERROR = "book-error.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> paramMap = request.getParameterMap();
        if (paramMap.isEmpty()) {
            showAllBooks(request, response);
            return;
        }
        if (paramMap.containsKey("create")) {
            createBook(request, response, paramMap);
            return;
        }
        if (paramMap.containsKey("edit")) {
            editBook(request, response, paramMap);
            return;
        }
        if (paramMap.containsKey("delete")) {
            deleteBook(request, response, paramMap);
            return;
        }
    }

    private Book getBookFrom(HttpServletRequest request, HttpServletResponse response,
                                 Map<String, String[]> parameters) throws ServletException, IOException {
        int id = 0;
        if (parameters.containsKey("id")) {
            String[] ids = parameters.get("id");
            if (ids.length > 0) {
                try {
                    id = Integer.parseInt(ids[0]);
                } catch (NumberFormatException ex) {
                    return null;
                }
            }
        }
        String title = "";
        if (parameters.containsKey("title")) {
            String[] titles = parameters.get("title");
            if (titles.length > 0) {
                title = titles[0];
            }
        }
        String author = "";
        if (parameters.containsKey("author")) {
            String[] authors = parameters.get("author");
            if (authors.length > 0) {
                author = authors[0];
            }
        }
        String publisher = "";
        if (parameters.containsKey("publisher")) {
            String[] publishers = parameters.get("publisher");
            if (publishers.length > 0) {
                publisher = publishers[0];
            }
        }
        float price = 0f;
        if (parameters.containsKey("price")) {
            String[] prices = parameters.get("price");
            if (prices.length > 0) {
                try {
                    price = Float.parseFloat(prices[0]);
                } catch (NumberFormatException ex) {
                    return null;
                }
            }
        }
        return new Book(id, title, author, publisher, price);
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response,
                            Map<String, String[]> parameters) throws ServletException, IOException {
        Book book = getBookFrom(request, response, parameters);
        if (book == null) {
            showError(request, response, "Some fields Invalid or Missing");
            return;
        }
        bookService.remove(book.getId());
        showAllBooks(request, response);
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response,
                               Map<String, String[]> parameters) throws ServletException, IOException {
        Book book = getBookFrom(request, response, parameters);
        if (book == null || book.isTrash()) {
            showError(request, response, "Some fields Invalid or Missing");
            return;
        }
        bookService.update(book);
        showAction(request, response, parameters, JSP_RESULT);
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response,
                               Map<String, String[]> parameters) throws ServletException, IOException {
        Book book = getBookFrom(request, response, parameters);
        if (book == null || book.isTrash()) {
            showError(request, response, "Some fields Invalid or Missing");
            return;
        }
        if (!bookService.add(book)) {
            showError(request, response, "Book Existed");
            return;
        }
        showAction(request, response, parameters, JSP_RESULT);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> paramMap = request.getParameterMap();
        if (paramMap.isEmpty()) {
            showAllBooks(request, response);
            return;
        }
        if (paramMap.containsKey("search")) {
            showAction(request, response, paramMap, JSP_RESULT);
            return;
        }
        if (paramMap.containsKey("create")) {
            request.getRequestDispatcher(JSP_CREATE)
                    .forward(request, response);
            return;
        }
        if (paramMap.containsKey("edit")) {
            showAction(request, response, paramMap, JSP_EDIT);
            return;
        }
        if (paramMap.containsKey("delete")) {
            showAction(request, response, paramMap, JSP_DELETE);
            return;
        }
    }

    private void showAllBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("books", bookService.findAll());
        request.getRequestDispatcher(JSP_ALL)
                .forward(request, response);
    }

    private void showAction(HttpServletRequest request, HttpServletResponse response,
                                Map<String, String[]> parameterMap,
                                String action) throws ServletException, IOException {
        if (parameterMap.containsKey("id")) {
            String[] ids = parameterMap.get("id");
            if (ids.length > 0) {
                try {
                    int id = Integer.parseInt(ids[0]);
                    Book book = bookService.findById(id);
                    if (book != null && !book.isTrash()) {
                        request.setAttribute("book", book);
                        request.getRequestDispatcher(action)
                                .forward(request, response);
                    }
                    else {
                        showAllBooks(request, response);
                    }
                } catch (NumberFormatException ex) {
                    showError(request, response, "Id Invalid");
                }
                return;
            }
        }
        request.getRequestDispatcher(JSP_SEARCH)
                .forward(request, response);
    }

    private void showError(HttpServletRequest request, HttpServletResponse response,
                           String message) throws ServletException, IOException {
        request.setAttribute("error", message);
        request.getRequestDispatcher(JSP_ERROR)
                .forward(request, response);
    }
}
