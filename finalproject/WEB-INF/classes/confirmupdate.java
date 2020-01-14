import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class confirmupdate extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    HttpSession session=request.getSession(false);
    if(session==null)
    {RequestDispatcher rd=request.getRequestDispatcher("login.html");
    rd.forward(request, response);}

    else{
    String id=(String)session.getAttribute("c_searchId");

    System.out.println(id);

    response.setContentType("text/html");
    PrintWriter out=response.getWriter();

   // String id=request.getParameter("id");
   // String fn=request.getParameter("fn");
   // String ln=request.getParameter("ln");
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
    System.out.println(mb+add+kl+al+sh+ch+co+fi+tl+bo+po+daman);


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/darzikhana";

    Connection con=DriverManager.getConnection(url, "root", "zain4744");

    Statement st=con.createStatement();


    
 
   // String query1 = "INSERT INTO customerdetails(customerId,firstName,lastName,mobileNumber,address,kameezLength,armLength,shoulder,chest,collar,fitting,trouserLength,bottomOpenning,pocket,daman)VALUES("+ id + ",'"+ fn + "','" + ln+ "','" + mb+ "','" + add+ "',"+ kl + ","+ al + ","+ sh + ","+ ch + ","+ co + ","+ fi + ","+ tl + ","+ bo + ",'"+ po + "','"+ daman + "') ";

    String query=
    "UPDATE customerdetails set mobileNumber='"+mb+"',address='"+add+"',kameezLength='"+kl+"',armLength='"+al+"',shoulder='"+sh+"',chest='"+ch+"',collar='"+co+"',fitting='"+fi+"',trouserLength='"+tl+"',bottomOpenning='"+bo+"',pocket='"+po+"',daman='"+daman+"' where customerId='"+id+"'   ";
    System.out.println(query);
   int rs = st.executeUpdate( query );

   System.out.println(rs);


    String i;
   if(rs > 0){
      i="true";
      request.setAttribute("status",new String(i));
      RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
      rd.forward(request, response);
      
    }
   
   else{ 
      i="false";
       request.setAttribute("status",new String(i));
       RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
      rd.forward(request, response);
         }



    
    //  RequestDispatcher rd=request.getRequestDispatcher("login.html");
    //  rd.forward(request, response); 	
    
    
    


     

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);}

}
