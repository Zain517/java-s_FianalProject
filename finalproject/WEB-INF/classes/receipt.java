import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class receipt extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
{    
   HttpSession session=request.getSession(false);
   System.out.println("session gets delete pg  :"+session);
  if(session==null) 
  {response.sendRedirect("login.html");}

   response.setContentType("text/html");
   PrintWriter out=response.getWriter();
  //  Cookie c[]=request.getCookies();

  //   if(c != null){
  //   for(int i=0;i<c.length;i++){
  //       //c[i].setValue(null);
  //       //c[i].setName(null);
  //       c[i].setMaxAge(0);
  //       c[i].setPath("/");
  //       response.addCookie(c[i]);
  //    }
  //   } 
  



    String id=request.getParameter("id");
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
  
  
      String query="Select * from orderdetails where orderId="+id+"  ";
      System.out.println(query);
      ResultSet rs = st.executeQuery( query );
      String i;
      if(rs.next()){
        i="order found";
        request.setAttribute("status",new String(i));
        RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
        rd.forward(request, response);
     }
  else{ 
      String query1 = "INSERT INTO orderdetails(orderId,fullName,suitQuantity,colorDesc,designType,submitDate,deliDate,description)VALUES("+ id + ",'"+ na + "','" + sq+ "','" + co+ "','" + dt+ "','"+ sub + "','"+ deli + "','"+ desc + "' ) ";
  
       System.out.println(query1);
  
        int rs1 = st.executeUpdate( query1);
  
       if(rs1==1){
         
        
        
    out.println("<html> <head> <title>Print Receipt</title><script > ");
    out.println("var res; function myfunction(){");
    out.println("res=prompt(\"Enter Order's Total Price\",'800');var desc;");
    out.println("if(res == null || res == \"\"){desc = \"You don't Enter any Price.\";}    ");
    out.println("else{desc = \" Total Amount : \" +res+ \" Rs Only.\";}   ");   
    out.println("document.getElementById(\"price\").innerHTML = desc;}");
    out.println("</script> </head>");


    out.println("<body onload=\"myfunction()\" ><h1 style=\"color:green;\" ><b><i>( Order Confirmed.... ) </i></b></h1>");

   // out.println("<strong>Order ID :</strong> " +rid+"  and "+fname+" ");out.println("<br>"); 

    out.println("<fieldset style=\"width:320px; border:2px solid red \">   <legend><b><i>( Receipt.....  ) </i></b></legend><br> ");
    out.println("<font size=\"6.5\"><b><u>Karachi Tailors</u></b></font> <br>  ");
    out.println(" &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <b><i> Railway Road Pattoki....</b></i> <br>");
    out.println(" &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <b><i> phone no :</b></i> 03024911945 <br>");
    out.println(" _________________________________<br> <br>");
    out.println("<strong>Order ID :</strong> " +id+" ");out.println("<br>"); 
    out.println("<strong>Name :</strong> " +na+" ");out.println("<br>"); 
    out.println("<strong>Suit(s) Quantity :</strong> " +sq+" ");out.println("<br>"); 
    out.println("<strong>Colors Description :</strong> " +co+" ");out.println("<br>"); 
    out.println("<strong>Design Type :</strong> " +dt+" ");out.println("<br>");
    out.println("<strong>Submit Date :</strong> " +sub+" ");out.println("<br>");
    out.println("<strong>Return Date'll be IA :</strong> " +deli+" ");out.println("<br>");
    out.println("<strong>Description :</strong> " +desc+" ");out.println("<br><br>");
    out.println(" <div id=\"price\" style=\"color:red\">  </div> ");

    out.println("<br><br><br><br><br><br><br><br><br><br>"); 
  
    out.println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;  <strong> Signature:______________</strong> <br><br>    ");

   // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy     HH:mm:ss");
    Date date = new Date();
    out.print(date);
  //  out.println(formatter.format(date)); 
    out.println("<input style=float:right; type=\"submit\" onclick=\"window.print();\" value=\"Print\" /> ");

    out.println("</fieldset>");
    
   
 
    
    out.println("</body></html>");

        



      
        }
    else{	
       i="order not added";
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
      doPost(request,response);
    }
}