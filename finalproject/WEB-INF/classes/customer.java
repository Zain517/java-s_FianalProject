import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class customer extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    HttpSession session=request.getSession(false);
  if(session==null) 
  {response.sendRedirect("login.html");}




	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

    String id=request.getParameter("id");
    String fn=request.getParameter("fn");
    String ln=request.getParameter("ln");
    String mb=request.getParameter("mb");
    String add=request.getParameter("add");
    String kl=request.getParameter("kl");
    String al=request.getParameter("al");
    String sh=request.getParameter("sh");
    String ch=request.getParameter("ch");
    String co=request.getParameter("co");
    String fi=request.getParameter("fi");
    String tl=request.getParameter("tl");
    String bo=request.getParameter("bo");
    String po=request.getParameter("po");
    String daman=request.getParameter("Daman");
    System.out.println(id+fn+ln+mb+add+kl+al+sh+ch+co+fi+tl+bo+po+daman);




    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/darzikhana";

    Connection con=DriverManager.getConnection(url, "root", "zain4744");

    Statement st=con.createStatement();


    String query="Select * from customerdetails where customerId="+id+"  ";
    System.out.println(query);
    ResultSet rs = st.executeQuery( query );
    String i;
    if(rs.next()){
      i="found";
      request.setAttribute("status",new String(i));
      RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
      rd.forward(request, response);
   }
else{ 
    String query1 = "INSERT INTO customerdetails(customerId,firstName,lastName,mobileNumber,address,kameezLength,armLength,shoulder,chest,collar,fitting,trouserLength,bottomOpenning,pocket,daman)VALUES("+ id + ",'"+ fn + "','" + ln+ "','" + mb+ "','" + add+ "','"+ kl + "','"+ al + "','"+ sh + "','"+ ch + "','"+ co + "','"+ fi + "','"+ tl + "','"+ bo + "','"+ po + "','"+ daman + "') ";

     System.out.println(query1);

      int rs1 = st.executeUpdate( query1);

     if(rs1==1){
       
      i="added";
      request.setAttribute("status",new String(i));
      RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
      rd.forward(request, response);
    
    //  RequestDispatcher rd=request.getRequestDispatcher("login.html");
    //  rd.forward(request, response); 	
    
    	}
	else{	
     i="not added";
  request.setAttribute("status",new String(i));
  RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
  rd.forward(request, response); 		}
    
    }



           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }


public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);}

}
