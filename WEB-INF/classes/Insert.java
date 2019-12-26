import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Insert extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

    String name=request.getParameter("n");
    String pwd=request.getParameter("p");

    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/darzikhana";

    Connection con=DriverManager.getConnection(url, "root", "zain4744");

    Statement st=con.createStatement();


    String query="Select * from login where username='"+name+"' ";
   
    ResultSet rs = st.executeQuery( query );
  
    if(rs.next()){

     out.println("<h1>Record already found</h1>");
   }
else{ String query1 = "INSERT INTO login(username,password)VALUES('"+ name + "','" + pwd+ "') ";

     System.out.println(query1);

      int rs1 = st.executeUpdate( query1);

     if(rs1==1){
     RequestDispatcher rd=request.getRequestDispatcher("login.html");
     rd.forward(request, response); 	
    
    	}
	else{	out.println("<h1>Record could not be inserted.</h1>"); 		}
    
    }


     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
