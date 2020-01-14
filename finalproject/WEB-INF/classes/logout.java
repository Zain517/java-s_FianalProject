import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class logout extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
{
  HttpSession session=request.getSession(false);
  if(session==null) 
 {response.sendRedirect("login.html");}

 else{ 

    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    session.invalidate();
    response.sendRedirect("login.html");
}
}

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
}

}