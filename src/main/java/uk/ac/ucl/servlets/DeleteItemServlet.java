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
        urlPatterns = "/deleteItem"
)


public class DeleteItemServlet extends HttpServlet
{

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    String id = request.getParameter("id");
    String item_id = request.getParameter("item_id");
    Model model = ModelFactory.getModel();
    model.deleteItemById(Integer.parseInt(id), Integer.parseInt(item_id));

    // Invoke the JSP.
    // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
//    ServletContext context = getServletContext();
//    RequestDispatcher dispatch = context.getRequestDispatcher("/itemLists.jsp");
//    dispatch.forward(request, response);
    response.sendRedirect("/itemList?id=" + id);
  }
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    String id = request.getParameter("id");
    String item_id = request.getParameter("item_id");
    Model model = ModelFactory.getModel();
    model.deleteItemById(Integer.parseInt(id), Integer.parseInt(item_id));

    // Invoke the JSP.
    // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
    response.sendRedirect("/itemList?id=" + id);
  }
}
