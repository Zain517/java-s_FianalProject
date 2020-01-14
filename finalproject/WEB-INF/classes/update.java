import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class update extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
{
  HttpSession session=request.getSession(false);
  if(session==null) 
  {response.sendRedirect("login.html");}
  else{
  
   String id=(String)session.getAttribute("c_searchId");
   //String fname=(String)request.getAttribute("c_searchname");

  System.out.println(id);

    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    // Cookie c[]=request.getCookies();
    
    // //for(int i=0;i<c.length;i++){
    //     String fname=c[0].getName();
    //     String id=c[0].getValue();

        

        try{
            Class.forName("com.mysql.jdbc.Driver");
        
            String url = "jdbc:mysql://127.0.0.1/darzikhana";
        
            Connection con=DriverManager.getConnection(url,"root","zain4744");
        
            Statement st=con.createStatement();
            
             String query="Select * from customerdetails where customerId="+id+"   ";
           
             ResultSet rs = st.executeQuery( query );
           
             
             if(rs.next()){
              
                //out.println("<h1>Record found</h1>");
        
                    int cid = rs.getInt("customerId");
                    String fn = rs.getString("firstName");
                    String ln = rs.getString("lastName");
                    String mb = rs.getString("mobileNumber");
                     String add = rs.getString("address");
                    // System.out.println(add);
                    double kl = rs.getDouble("kameezLength");
                    double al = rs.getDouble("armLength");
                    double sh = rs.getDouble("shoulder");
                    double ch = rs.getDouble("chest");
                    double co = rs.getDouble("collar");
                    double fi = rs.getDouble("fitting");
                    double tl = rs.getDouble("trouserLength");
                    double bo = rs.getDouble("bottomOpenning");
                    String po = rs.getString("pocket");
                    String da = rs.getString("daman");
                    System.out.println(po);
        
               





      // out.println("Welcome " + name+"<br>Your password is "+password+"<br>");
    //}    
    


      out.println("<html> <head> <title> Update Customer</title>");
      out.println("<script language=\"JavaScript\" type=\"text/javaScript\">      ");
      out.println("function validate(){	");
      out.println("if ( document.f.mb.value == \"\" ) {var errors=\"Mobile no. is empty!!\"; document.getElementById(\"mobile\").innerHTML=errors;document.f.mb.focus(); return false; } ");
      out.println("var mail=document.forms['f']['mb'].value;");
      out.println("if(mail.length<11 || mail.length>15 ) { var errors=\"In_Valid (minimum 11 digits).....!!\";document.getElementById(\"mobile\").innerHTML=errors;document.f.mb.focus();return false; }");
      out.println("if ( document.f.add.value == \"\" ){ var errors=\"Address is empty!!\"; document.getElementById(\"address\").innerHTML=errors;document.f.add.focus(); return false;}");
      out.println("if ( document.f.kl.value == \"\" ) { var errors=\"kameez-Length is Empty...!!\";document.getElementById(\"kl\").innerHTML=errors;document.f.kl.focus();return false; }");
      out.println("if ( document.f.al.value == \"\" ){var errors=\"Arm-Length is Empty...!!\"; document.getElementById(\"al\").innerHTML=errors;document.f.al.focus(); return false; }");
      out.println("if ( document.f.sh.value == \"\" ){var errors=\"Shoulder-Length is Empty...!!\";document.getElementById(\"sh\").innerHTML=errors;document.f.sh.focus();return false; }");
      out.println("if ( document.f.ch.value == \"\" ){var errors=\"Chest-Length is Empty...!!\";document.getElementById(\"ch\").innerHTML=errors;document.f.ch.focus();return false;}");
      out.println("if ( document.f.co.value == \"\" ){var errors=\"Collar-Length is Empty...!!\";document.getElementById(\"co\").innerHTML=errors;document.f.co.focus(); return false; }");
      out.println("if ( document.f.fi.value == \"\" ) { var errors=\"Fitting-Length is Empty...!!\";document.getElementById(\"fi\").innerHTML=errors;document.f.fi.focus();return false;}");
      out.println("if ( document.f.tl.value == \"\" ){var errors=\"Trouser-Length is Empty...!!\"; document.getElementById(\"tl\").innerHTML=errors;document.f.tl.focus(); return false;}");
      out.println("if ( document.f.bo.value == \"\" ){ var errors=\"Bottom-Opening-Length is Empty...!!\";document.getElementById(\"bo\").innerHTML=errors;document.f.bo.focus(); return false;}");
      out.println("if ( document.f.po.value == \"\" ){var errors=\"Number of Pockets are Empty...!!\";document.getElementById(\"po\").innerHTML=errors;document.f.po.focus(); return false; }");
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
  
  

      out.println("<div > <fieldset style=\"width:480px; margin-left:500px;\">      ");
      out.println("<form name=\"f\" action=\"finalupdate\" method=\"post\" onsubmit=\"return validate()\" >      ");
      out.println("<h1><b>Update Customer's Details </b></h1><br>");
     
      out.println("<strong>Mobile# : </strong><input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Mobile Number  \"  value=" + mb+" name=\"mb\" onKeyPress=\"return letternumber(event)\"><div id=\"mobile\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Address : </strong><input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Address  \"  value=\"   " + add+ "    \"  name=\"add\"><div id=\"address\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<h1><b>Customer's Measurements<sup> (inches)</sup></b></h1>      ");
      out.println("<br>");
      out.println("<strong>Kameez Length : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Kameez-Length  \"    value=" + kl+"  name=\"kl\" onKeyPress=\"return letternumber(event)\">  <div id=\"kl\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Arm Length : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Arm-Length  \"  value=" + al+" name=\"al\" onKeyPress=\"return letternumber(event)\"> <div id=\"al\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Shoulder : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Shoulder  \"  value=" + sh+" name=\"sh\" onKeyPress=\"return letternumber(event)\"> <div id=\"sh\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Chest : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Chest  \"   value=" +ch+"  name=\"ch\" onKeyPress=\"return letternumber(event)\"> <div id=\"ch\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Collar : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Collar \"  value=" + co+" name=\"co\" onKeyPress=\"return letternumber(event)\"> <div id=\"co\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Fitting : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Fitting  \"  value=" + fi+" name=\"fi\" onKeyPress=\"return letternumber(event)\"> <div id=\"fi\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Trouser Length : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Trouser-Length  \"    value=" + tl+" name=\"tl\" onKeyPress=\"return letternumber(event)\"> <div id=\"tl\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Bottom Openning : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Bottom-Opening  \"  value=" + bo+" name=\"bo\" onKeyPress=\"return letternumber(event)\"> <div id=\"bo\" style=\"color:red\"></div>");
      out.println("<br>");
      out.println("<strong>Pockets : </strong><input style=\"width:150px;padding:10px;\"  type=\"text\"  placeholder=\"Pockets \"   value=\" "+ po+"  \" name=\"po\" > <div id=\"po\" style=\"color:red\"></div>");
      out.println("<br><strong> Daman : </strong>");
      out.println("<select name=Daman : ><option value=\"square\">Square</option> <option value=\"circle\">Circular</option></select>");
      out.println("<br>");
      out.println("<input style=float:right; class=\"button\" type=\"submit\" id=\"order\" value=\"Update Customer\" />      ");
      out.println("</form>");
      out.println("</fieldset></div>");



      
     // String s=(String)request.getAttribute("status");
     

        
      out.println(" </div></body> </html> ");
        




   
    }
    
    else{
     //out.println("else");
     
    //  out.println(i);
     String err="No record found........";
     
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