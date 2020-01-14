import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class updatefinal extends HttpServlet {
  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    HttpSession session=request.getSession(false);
    if(session==null) 
    {response.sendRedirect("login.html");}
    
    else{
     String id=(String)session.getAttribute("orderId");

    response.setContentType("text/html");
    PrintWriter out=response.getWriter();

   // out.println("final");
    // Cookie c[]=request.getCookies();
    
    // //for(int i=0;i<c.length;i++){
    //     String fname=c[0].getName();
    //     String id=c[0].getValue();



        String na=request.getParameter("na");
        String sq=request.getParameter("sq");
        String co=request.getParameter("co");
        String dt=request.getParameter("dt");
        //java.util.Date sub = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("subDate"));
       // java.util.Date deli = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deliDate"));
    
        String sub=request.getParameter("subDate");
        String deli=request.getParameter("deliDate");
        String desc=request.getParameter("t");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/darzikhana";

    Connection con=DriverManager.getConnection(url, "root", "zain4744");

    Statement st=con.createStatement();


    
 
   // String query1 = "INSERT INTO customerdetails(customerId,firstName,lastName,mobileNumber,address,kameezLength,armLength,shoulder,chest,collar,fitting,trouserLength,bottomOpenning,pocket,daman)VALUES("+ id + ",'"+ fn + "','" + ln+ "','" + mb+ "','" + add+ "',"+ kl + ","+ al + ","+ sh + ","+ ch + ","+ co + ","+ fi + ","+ tl + ","+ bo + ",'"+ po + "','"+ daman + "') ";

    String query=
    "UPDATE orderdetails set fullName='"+na+"',suitQuantity='"+sq+"',colorDesc='"+co+"',designType='"+dt+"',submitDate='"+sub+"',deliDate='"+deli+"',description='"+desc+"' where orderId='"+id+"'  ";
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
