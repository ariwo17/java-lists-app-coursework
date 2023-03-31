package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servlet invoked to display a list of patients. Note that this data is just example data,
// you replace it with your data.
// The url http://localhost:8080/patientList.html is mapped to calling doGet on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet(
        urlPatterns = "/new_itemList"
)


public class NewItemListServlet extends HttpServlet
{

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    // Invoke the JSP.
    // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/new_itemList.jsp");
    dispatch.forward(request, response);
  }
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    String title = request.getParameter("title");
    String body = request.getParameter("body");
    Model model = ModelFactory.getModel();
    System.out.println(title + " " + body);
    model.createNewItemList(title, body);
    // Invoke the JSP.
    // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
//    ServletContext context = getServletContext();
//    RequestDispatcher dispatch = context.getRequestDispatcher("/new_itemList.jsp");
//    dispatch.forward(request, response);
    response.sendRedirect("/itemLists.html");
  }
}
