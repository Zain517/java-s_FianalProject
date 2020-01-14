import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class updateorder extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
{
  HttpSession session=request.getSession(false);
  if(session==null) 
 {response.sendRedirect("login.html");}

 else{ 

    response.setContentType("text/html");
    PrintWriter out=response.getWriter();

    

        String i;
        String input = JOptionPane.showInputDialog("Enter Valid Order-ID for Updation....\n");
       // if(input.equals(null)){out.println("you don't enter any ID");}
       // out.println(input);

        try{
            Class.forName("com.mysql.jdbc.Driver");
        
            String url = "jdbc:mysql://127.0.0.1/darzikhana";
        
            Connection con=DriverManager.getConnection(url,"root","zain4744");
        
            Statement st=con.createStatement();
            
             String query="Select * from orderdetails where orderId="+input+"  ";
           
             ResultSet rs = st.executeQuery( query );
           
             
             if(rs.next()){

                // Cookie c1=new Cookie("id",input);
                // c1.setMaxAge(30);
                // response.addCookie(c1);
                session.setAttribute("orderId", input);
              
                //out.println("<h1>Record found</h1>");
        
                    int id = rs.getInt("orderId");
                    String na = rs.getString("fullName");
                    String sq = rs.getString("suitQuantity");
                    String co = rs.getString("colorDesc");
                    String dt = rs.getString("designType");
                    String sub = rs.getString("submitDate");
                    String deli = rs.getString("deliDate");
                    String desc = rs.getString("description");
        
        
               
    


        out.println("<html> <head> <title> Update order</title>");
        out.println("<script language=\"JavaScript\" type=\"text/javaScript\">      ");
        out.println("function validate(){if ( document.f.id.value == \"\" ){"); 
        out.println("var errors=\"Order's ID is empty!!\";   "); 
        out.println("document.getElementById(\"ID\").innerHTML=errors;"); 
        out.println("document.f.id.focus();return false; }  "); 
        out.println("if ( document.f.na.value == \"\" ){var errors=\"Customer's name is empty!!\";document.getElementById(\"name\").innerHTML=errors;"); 
        out.println("document.f.na.focus();return false; }"); 
        out.println("if ( document.f.sq.value == \"\" ){var errors=\"Quantity is empty!!\";"); 
        out.println("document.getElementById(\"sq\").innerHTML=errors;"); 
        out.println("document.f.sq.focus();return false;}  "); 
        out.println("var mail=document.forms['f']['sq'].value;");
        out.println("if(mail>=99 ){var errors=\"Too much Suit(s) Quantity [1-99].....!!\";document.getElementById(\"co\").innerHTML=errors;document.f.sq.focus();return false; }");
        out.println("if ( document.f.co.value == \"\" ){var errors=\"Color-Desc is empty!!\";document.getElementById(\"co\").innerHTML=errors; document.f.co.focus();return false;}");   
        out.println("if(mail<='0' ){var errors=\"In_Valid Suit(s) Quantity[1-99].....!!\";document.getElementById(\"co\").innerHTML=errors;document.f.sq.focus();return false; }"); 
        out.println("if ( document.f.dt.value == \"\" ){var errors=\"Design-type is empty!!\";document.getElementById(\"dt\").innerHTML=errors;document.f.dt.focus();return false;}"); 
        out.println("if((document.f.subDate.value) > (document.f.deliDate.value)) "); 
        out.println(" {var errors=\"Submission Date always less than delivery date!!\";document.getElementById(\"date\").innerHTML=errors;return false;}"); 
        out.println("return true;}"); 

      
      //letternumber.....


  out.println("function letternumber(event){		var keychar;keychar = event.key;	if (((\".+-0123456789\").indexOf(keychar) > -1)) return true; if (event.keyCode === 13){ event.preventDefault();document.getElementById(\"order\").click();}else{	alert(\" Should only Numerics.....!!\");			return false;	}}"); 
 
 
  //nameVelidation....
 
 
   out.println("function nameVelidation(event)	{	var keychar;	keychar = event.key;	if (((\"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ \").indexOf(keychar) > -1)) return true;  if (event.keyCode === 13){ event.preventDefault();document.getElementById(\"order\").click();}  else{alert(\"Special & numeric charaters not Allowed...!!\");	return false;	}	}"); 
  
  
   out.println("</script> "); 
   //ScriptEnd.....


   
  out.println("<style>"); 
  out.println(".button{"); 
  out.println("background-color:blue;"); 
  out.println("	border:2px solid #white;"); 
  out.println("opacity:0.80;"); 
  out.println("	border-radius:1px;"); 
  out.println("width:150px;"); 
  out.println("height:35px;"); 
  out.println("color:white;"); 
  out.println("transition:0.5s;"); 
  out.println("transition:0.5s;}"); 
  out.println("</style>"); 


  out.println("</head> <body>");
  //Header End Body Start from here....
  
  

  out.println("<div style=\" float:center;\"> "); //right div
  out.println("<fieldset style=\"width:65px; margin-right:200px;\">  "); 
  out.println("<legend><h1><b><i>( Update Order's Details  ) </i></b></h1></legend>  "); 
  out.println("<form name=\"f\"   action=\"updateorder\"   method=\"post\"     onsubmit=\"return validate()\" >  "); 
 // out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\" value=" + id+" placeholder=\"New Order ID  \" name=\"id\" onKeyPress=\"return letternumber(event)\">  <div id=\"ID\" style=\"color:red\"></div>"); 
 // out.println("<br>"); 
  out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Customer Name  \" value=" + na+" name=\"na\" onKeyPress=\"return nameVelidation(event)\">  <div id=\"name\" style=\"color:red\"></div>"); 
  out.println("<br>"); 
  out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Suit(s) Quantity  \"  value=" + sq+"  name=\"sq\" onKeyPress=\"return letternumber(event)\">  <div id=\"sq\" style=\"color:red\"></div>"); 
  out.println("<br>"); 
  //out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Colors-Description  \" name=\"co\" >  <div id=\"co\" style=\"color:red\"></div>"); 
  out.println("<textarea name=\"co\" rows=\"3\" cols=\"48\"  placeholder=\"Colors- Description......\">"+co+"</textarea>  <div id=\"co\" style=\"color:red\"></div> ");
  out.println("<br>"); 
 // out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Design-type /Style \" name=\"dt\">  <div id=\"dt\" style=\"color:red\"></div>"); 
  out.println("<textarea name=\"dt\" rows=\"3\" cols=\"48\" placeholder=\"Design-Type......\">"+dt+"</textarea>  <div id=\"dt\" style=\"color:red\"></div> "); 
  out.println("<br>"); 
  out.println("<strong> Submit Date:       &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;   Delivery Date:</strong><br>  "); 
  out.println("<input type=\"date\" name=\"subDate\" value=" + sub+">&emsp;&emsp;&emsp;  "); 
  out.println("<input type=\"date\" name=\"deliDate\" value=" + deli+"> "); 
  out.println("<div id=\"date\" style=\"color:red\"></div>  "); 
  out.println("<br><br>"); 
  out.println("<textarea name=\"t\" rows=\"5\" cols=\"48\"  placeholder=\" Description......\">"+desc+"</textarea>  "); 
  out.println("<br><br>"); 
  out.println("<input style=float:right; class=\"button\" type=\"submit\"   id=\"order\"  value=\"Update Order\" />  "); 
  out.println("</form> </fieldset> </div> ");


      
     // String s=(String)request.getAttribute("status");
     

        
      out.println(" </div></body> </html> ");
        




   
    }
    
    else{
        i="order false";
        request.setAttribute("status",new String(i));
        RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
       rd.forward(request, response);
     
    } 
        //out.println("</body></html>");
        st.close();
        con.close();

 }catch(Exception e){

   out.println(" ");
 }

  

   
    
        

}
}

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
}

}