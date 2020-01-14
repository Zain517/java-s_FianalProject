import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class home extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
{
  HttpSession session=request.getSession(false);
  if(session==null) 
 {response.sendRedirect("login.html");}

 else{ 
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    out.println("<html><title>Home</title>");
    out.println("<style>");
    out.println("#example1 {");
    out.println(" background-image:url('stich.gif');");
    out.println("background-size:100%;opacity:0.70;background-repeat: repeat-y;");
    out.println(" background-attachment: fixed;height:100%; width:100%;}    ");
    out.println(".button{"); 
    out.println("background-color:blue;"); 
    out.println("	border:2px solid #white;"); 
    out.println("opacity:0.80;"); 
    out.println("	border-radius:1px;"); 
    out.println("width:125px;"); 
    out.println("height:35px;"); 
    out.println("color:white;"); 
    out.println("transition:0.5s;"); 
    out.println("transition:0.5s;}"); 
    out.println("</style>"); 

    out.println("<body> <div  id=\"example1\">");
    out.println("<br><center><h1><i><font size=8>===== ( Karachi  Tailor ) =====</font></i></h1></center>    ");
    out.println("<form method=\"post\" action=\"placeorder\">    ");
    out.println("<input type=\"submit\" class=\"button\" value=\"Place Order\">    ");
    out.println("</form>");

    out.println("<form method=\"post\" action=\"orderupdate\"> ");
    out.println("<input type=\"submit\" class=\"button\" value=\"Update Order\">    ");
    out.println("</form>");

    out.println("<form method=\"post\" action=\"deleteorder\">");
    out.println("<input type=\"submit\" class=\"button\" value=\"Delete Order\">    ");
    out.println("</form>");

    out.println("<a href=\"Add_customer.html\" ><input type=submit class=\"button\" value=Add-Customer> </a>");
    out.println("<br><br>");

    out.println("<form method=\"post\" action=\"placeorder\">");
    out.println("<input type=\"submit\" class=\"button\" value=\"Search Customer\">    ");
    out.println("</form>");

    out.println("<form method=\"post\" action=\"logout\">");
    out.println("<input type=\"submit\" class=\"button\" value=\"Log Out\">    ");
    out.println("</form>");

    out.println("</div> </body> </html>");

    




}
}

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
}

}