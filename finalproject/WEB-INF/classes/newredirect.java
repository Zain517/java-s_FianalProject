import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class newredirect extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    
    HttpSession session=request.getSession(false);
   if(session==null) 
   {response.sendRedirect("login.html");}
    else{ 
    response.setContentType("text/html");
    
    // get PrintWriter object
    PrintWriter out = response.getWriter();
        //out.println("<html> gjs </html>");
        RequestDispatcher rd=request.getRequestDispatcher("Add_customer.html");
         rd.forward(request, response); 	
   }
  }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }
          
}


