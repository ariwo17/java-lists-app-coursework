/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2023-03-19 14:36:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import uk.ac.ucl.model.ItemList;
import java.time.LocalDateTime;
import uk.ac.ucl.model.ItemList;
import uk.ac.ucl.model.Item;

public final class note_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("uk.ac.ucl.model.Item");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.time.LocalDateTime");
    _jspx_imports_classes.add("uk.ac.ucl.model.ItemList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/meta.jsp", out, false);
      out.write("\r\n");
      out.write("  <title>Lists App</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/header.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("  <div class=\"itemList\">\r\n");
      out.write("    ");

      ItemList itemList = (ItemList) request.getAttribute("itemList");
      String title = itemList.getTitle();
      LocalDateTime dateTime = itemList.getDateTime();
      int id = itemList.getId();
    
      out.write("\r\n");
      out.write("    <h2 id=\"noteTitle\" class=\"item_text\">");
      out.print( title );
      out.write("</h2>\r\n");
      out.write("    <form>\r\n");
      out.write("      <div id=\"renamePanel\">\r\n");
      out.write("        <input id=\"rename\" type=\"button\" value=\"Rename\" onclick=\"makeEditable()\">\r\n");
      out.write("        <br>\r\n");
      out.write("        <input id=\"save\" hidden=\"hidden\" type=\"button\" value=\"Save\" onclick=\"updateEdit(");
      out.print( id );
      out.write(")\">\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("    <p id=\"noteDateTime\" class=\"item_text\"><i>Created at ");
      out.print( dateTime);
      out.write("</i></p>\r\n");
      out.write("    <p id=\"noteBody\" class=\"item_text\">\r\n");
      out.write("      ");

        String body = itemList.getBody();
        String itemId = String.valueOf(itemList.getId());
        String action = "/new_item?id=" + itemId;
      
      out.write("\r\n");
      out.write("      ");
      out.print( body );
      out.write("<br><br>\r\n");
      out.write("    <a class=\"addNewItem\" href=");
      out.print( action );
      out.write(">Add a new item</a>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <ul>\r\n");
      out.write("      ");

        List<Item> items = itemList.getItems();
        for (Item item : items)
        {
          String href = "item?id=" + itemList.getId() + "&item_id=" + item.getId();
          String output = "<b>" + item.getId() + ".</b> " + item.getBody();
          String deleteHref = "deleteItem?id=" + itemList.getId() + "&item_id=" + item.getId();
      
      out.write("\r\n");
      out.write("      <li class=\"itemLink\"><a href=\"");
      out.print(href);
      out.write('"');
      out.write('>');
      out.print(output);
      out.write("&nbsp;</a><a class=\"deleteItem\" href=\"");
      out.print(deleteHref);
      out.write("\">Delete</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <div class=\"noteSeparator\"></div>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("    </p>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<style>\r\n");
      out.write("  .itemList {\r\n");
      out.write("    background-color: beige;\r\n");
      out.write("    border-style: solid;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .item_text {\r\n");
      out.write("    margin-left: 10px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  body {\r\n");
      out.write("    background-color: lightseagreen;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .itemLink {\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    background-color: aqua;\r\n");
      out.write("    border: 2px solid black;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  ul {\r\n");
      out.write("    list-style-type: none;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  li {\r\n");
      out.write("    margin-left: 10px;\r\n");
      out.write("    margin-right: 10px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  a {\r\n");
      out.write("    color: black;\r\n");
      out.write("    text-decoration: none; /* no underline */\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  #rename {\r\n");
      out.write("    padding: 3px;\r\n");
      out.write("    background-color: green;\r\n");
      out.write("    color: white;\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  #save {\r\n");
      out.write("    padding: 3px;\r\n");
      out.write("    background-color: purple;\r\n");
      out.write("    color: white;\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .addNewItem {\r\n");
      out.write("    padding: 3px;\r\n");
      out.write("    background-color: darkblue;\r\n");
      out.write("    color: white;\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .deleteItem {\r\n");
      out.write("    padding: 2px;\r\n");
      out.write("    margin-left: 2px;\r\n");
      out.write("    background-color: #bf0000;\r\n");
      out.write("    color: white;\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .noteSeparator {\r\n");
      out.write("    padding: 2px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  #renamePanel {\r\n");
      out.write("    margin-left: 10px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("  function makeEditable() {\r\n");
      out.write("    console.log(\"Make editable clicked!\");\r\n");
      out.write("    var e = document.getElementById(\"noteTitle\");\r\n");
      out.write("    var renewBtn = document.getElementById(\"rename\");\r\n");
      out.write("    var saveBtn = document.getElementById(\"save\");\r\n");
      out.write("    var d = document.createElement('input');\r\n");
      out.write("    d.value = e.innerHTML;\r\n");
      out.write("    e.parentNode.replaceChild(d, e);\r\n");
      out.write("    d.id = \"newTitle\";\r\n");
      out.write("    renewBtn.style.display = \"none\";\r\n");
      out.write("    saveBtn.style.display = \"inline-block\";\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  function updateEdit(id) {\r\n");
      out.write("    let e = document.getElementById(\"newTitle\");\r\n");
      out.write("    let newUrl = \"/rename?id=\" + id + \"&title=\" + e.value;\r\n");
      out.write("    let redirectUrl = \"/itemList?id=\" + id;\r\n");
      out.write("    fetch(newUrl, {\r\n");
      out.write("      method: 'POST'\r\n");
      out.write("    })\r\n");
      out.write("            .then(response => window.location.replace(redirectUrl))\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
