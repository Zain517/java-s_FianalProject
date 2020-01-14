import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Search extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
    
    
    PrintWriter out = response.getWriter();

    String u_name=request.getParameter("n");
    String pwd=request.getParameter("p");
    System.out.println(u_name);
    


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/darzikhana";

    Connection con=DriverManager.getConnection(url,"root","zain4744");

    Statement st=con.createStatement();
    
     String query="Select * from login where username='"+u_name+"' AND  password='"+pwd+"' ";
   
     ResultSet rs = st.executeQuery( query );
   
     if(rs.next()){

        String name = rs.getString("username");
        String pass = rs.getString("password");
        String type = rs.getString("type");

        HttpSession session = request.getSession(true);
        session.setAttribute("username", name);
        session.setAttribute("password", pass);
        session.setAttribute("type", type);

          if(type.equals("1"))
          {
            RequestDispatcher rd=request.getRequestDispatcher("/home");
                 rd.forward(request, response);
          }
          if(type.equals("0"))
          {
            RequestDispatcher rd=request.getRequestDispatcher("extra.html");
                 rd.forward(request, response);
          }
    	    

	  }
     
     else{
            out.println(" <html> <head> <title> login</title> <script language=\"JavaScript\" type=\"text/javaScript\">     function validate()       ");
            out.println(" {	if ( document.f.n.value == \"\" ){var errors=\"Username is empty!!\";      document.getElementById(\"name\").innerHTML=errors;  document.f.n.focus();return false; }            ");
            out.println(" if(document.f.p.value == \"\")	{var errors=\"password is empty!!\";        document.getElementById(\"p\").innerHTML=errors;      document.f.p.focus();return false;}	            ");
            out.println(" return true;}  ");
            out.println(" function fun(){alert(\"Username Password Error\");}");
            out.println("</script><style>"); 
            out.println(".button{"); 
            out.println("background-color:blue;"); 
            out.println("	border:2px solid #white;"); 
            out.println("opacity:0.80;"); 
            out.println("	border-radius:1px;"); 
            out.println("width:105px;"); 
            out.println("height:35px;"); 
            out.println("color:white;"); 
            out.println("transition:0.5s;"); 
            out.println("transition:0.5s;}"); 
            out.println("</style> </head> "); 
            out.println(" <body onload=\"fun()\"> ");
            out.println(" <fieldset style=\"width:440px; margin-left:500px;\">             ");
            out.println(" <h1><b>Welcome the Darzi-Khana</b></h1>    <br>         ");
            out.println(" <form name=\"f\" action=\"Search\" method=\"post\" onsubmit=\"return validate()\" >     <br>");
            out.println(" <input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Username  \" name=\"n\">            ");
            out.println("<div id=\"name\" style=\"color:red\"></div>   <br>         ");
            out.println(" <input type=\"password\" style=padding:10px; placeholder=\"Password\" name=\"p\"><div id=\"p\" style=\"color:red\"></div>            ");
            out.println(" <input style=float:right; class=\"button\" type=\"submit\" value=\"Next\" />            ");
            out.println(" </form> </fieldset> ");
            out.println(" </body> ");
            out.println(" </html>");
          

          }



           st.close();
           con.close();

    }catch(Exception e){

      out.println(" ");
    }

  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);}

}
