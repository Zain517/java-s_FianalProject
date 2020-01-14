import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class neworder extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    HttpSession session=request.getSession(false);
    if(session==null)
    {RequestDispatcher rd=request.getRequestDispatcher("login.html");
    rd.forward(request, response);}

    String sid=(String)session.getAttribute("type");
    System.out.println(sid);
   if( sid.equals("0"))
   {RequestDispatcher rd=request.getRequestDispatcher("login.html");
    rd.forward(request, response);}


	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

   //cvalidate.......

  out.println("<html>");  
  out.println("<head>"); 
  out.println("<title> Add Order</title>"); 
  out.println("<script language=\"JavaScript\" type=\"text/javaScript\">  "); 
  out.println("function cvalidate(){if ( document.cf.rid.value == \"\" ){"); 
  out.println("var errors=\"Customer's ID is empty!!\";"); 
  out.println("document.getElementById(\"rid\").innerHTML=errors;		document.cf.rid.focus();"); 
  out.println("return false;}"); 
  out.println("if ( document.cf.fn.value == \"\" ){"); 
  out.println("var errors=\"First name is empty!!\";"); 
  out.println("document.getElementById(\"fn\").innerHTML=errors;"); 
  out.println("document.cf.fn.focus();return false;}"); 
  out.println("if ( document.cf.ln.value == \"\" ) {var errors=\"Last name is empty!!\";"); 
  out.println("document.getElementById(\"ln\").innerHTML=errors;"); 
  out.println("document.cf.ln.focus();return false;}"); 
  out.println("return true;}"); 


//validate......

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
  out.println("width:105px;"); 
  out.println("height:35px;"); 
  out.println("color:white;"); 
  out.println("transition:0.5s;"); 
  out.println("transition:0.5s;}"); 
  out.println("</style>"); 


  out.println("</head> <body>");
  //Header End Body Start from here....
  
  
//

  out.println("<div>");  //main div

  out.println("<div style=\" float:right;\"> "); //right div
  out.println("<fieldset style=\"width:65px; margin-right:200px;\">  "); 
  out.println("<legend><h1><b><i>( New Order's Details  ) </i></b></h1></legend>  "); 
  out.println("<form name=\"f\"   action=\"generatereceipt\"   method=\"post\"     onsubmit=\"return validate()\" >  "); 
  out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"New Order ID  \" name=\"id\" onKeyPress=\"return letternumber(event)\">  <div id=\"ID\" style=\"color:red\"></div>"); 
  out.println("<br>"); 
  out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Customer Name  \" name=\"na\" onKeyPress=\"return nameVelidation(event)\">  <div id=\"name\" style=\"color:red\"></div>"); 
  out.println("<br>"); 
  out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Suit(s) Quantity  \" name=\"sq\" onKeyPress=\"return letternumber(event)\">  <div id=\"sq\" style=\"color:red\"></div>"); 
  out.println("<br>"); 
  //out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Colors-Description  \" name=\"co\" >  <div id=\"co\" style=\"color:red\"></div>"); 
  out.println("<textarea name=\"co\" rows=\"3\" cols=\"48\" placeholder=\"Colors- Description......\"></textarea>  <div id=\"co\" style=\"color:red\"></div> ");
  out.println("<br>"); 
 // out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Design-type /Style \" name=\"dt\">  <div id=\"dt\" style=\"color:red\"></div>"); 
 out.println("<textarea name=\"dt\" rows=\"3\" cols=\"48\" placeholder=\"Design-Type......\"></textarea>  <div id=\"dt\" style=\"color:red\"></div> "); 
 out.println("<br>"); 
  out.println("<strong> Submit Date:       &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;   Delivery Date:</strong><br>  "); 
  out.println("<input type=\"date\" name=\"subDate\" value=\"2020-01-01\">&emsp;&emsp;&emsp;  "); 
  out.println("<input type=\"date\" name=\"deliDate\" value=\"2020-01-07\"> "); 
  out.println("<div id=\"date\" style=\"color:red\"></div>  "); 
  out.println("<br><br>"); 
  out.println("<textarea name=\"t\" rows=\"5\" cols=\"48\" placeholder=\" Description......\"></textarea>  "); 
  out.println("<br><br>"); 
  out.println("<input style=float:right; class=\"button\" type=\"submit\"   id=\"order\"  value=\"Add Order\" />  "); 
  out.println("</form> </fieldset> </div> "); 

//right div end


  out.println("<div style=\"float:left;\">"); //left div start
  out.println("<fieldset style=\"width:65px; margin-left:100px;\">  "); 
  out.println("<legend><h1><b><i>( Customer's Details  ) </i></b></h1></legend>  "); 
  out.println("<form name=\"cf\" action=\"customersearch\" method=\"post\" onsubmit=\"return cvalidate()\" >  "); 
  out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Registered Customer ID  \" name=\"rid\" onKeyPress=\"return letternumber(event)\">  "); 
  out.println("<div id=\"rid\" style=\"color:red\"></div>  "); 
  out.println("<br>"); 
  out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"First Name  \" name=\"fn\" onKeyPress=\"return nameVelidation(event)\"> <div id=\"fn\" style=\"color:red\"></div>"); 
  out.println("<br>"); 
  out.println("<input style=\"width:350px;padding:10px;\"  type=\"text\"  placeholder=\"Last Name  \" name=\"ln\" onKeyPress=\"return nameVelidation(event)\">  <div id=\"ln\" style=\"color:red\"></div>"); 
  out.println("<br>"); 
  out.println("<input style=float:right; class=\"button\" type=\"submit\" id=\"search\" value=\"Search \" />  "); 
  out.println("</form> </fieldset> <br>"); 


  out.println("<div>"); //left down div
  //out.println("<fieldset style=\"width:350px; height:250px; margin-left:100px;\">  "); 



  String s=(String)request.getAttribute("status");


///////Search Result

    if(s.equals("1")){

    out.println("<fieldset style=\"width:350px;  margin-left:100px;\">  "); 

    int id=(Integer)request.getAttribute("cid");
    String fn=(String)request.getAttribute("fn");
    String ln=(String)request.getAttribute("ln");
    String mb=(String)request.getAttribute("mb");
    String add=(String)request.getAttribute("add");
    double kl=(Double)request.getAttribute("kl");
    double al=(Double)request.getAttribute("al");
    double sh=(Double)request.getAttribute("sh");
    double ch=(Double)request.getAttribute("ch");
    double co=(Double)request.getAttribute("co");
    double fi=(Double)request.getAttribute("fi");
    double tl=(Double)request.getAttribute("tl");
    double bo=(Double)request.getAttribute("bo");
    String po=(String)request.getAttribute("po");
    String da=(String)request.getAttribute("da");


    out.println("<h1 style=\"color:green;\">Record found...</h1>");
    out.println("<strong>Customer ID:</strong> " +id+" ");out.println("<br>"); 
    out.println("<strong>First Name:</strong> " +fn+" ");out.println("<br>"); 
    out.println("<strong>Last Name:</strong> " +ln+" ");out.println("<br>"); 
    out.println("<strong>Mobile#:</strong> " +mb+" ");out.println("<br>"); 
    out.println("<strong>Address:</strong> " +add+" ");out.println("<br>"); 
    out.println("<strong>Kameez Length:</strong> " +kl+ " inches ");out.println("<br>"); 
    out.println("<strong>Arm Length:</strong> " +al+ " inches ");out.println("<br>"); 
    out.println("<strong>Shoulder:</strong> " +sh+ " inches ");out.println("<br>"); 
    out.println("<strong>Chest:</strong> " +ch+ " inches ");out.println("<br>"); 
    out.println("<strong>Collar:</strong> " +co+ " inches ");out.println("<br>"); 
    out.println("<strong>Fitting:</strong> " +fi+ " inches ");out.println("<br>"); 
    out.println("<strong>Trouser Length:</strong> " +tl+ " inches ");out.println("<br>"); 
    out.println("<strong>Narrow Bottom:</strong> " +bo+ " inches ");out.println("<br>"); 
    out.println("<strong>Pockects:</strong> " +po+" ");out.println("<br>"); 
    out.println("<strong>Daman Style:</strong> " +da+" ");out.println("<br>");
    out.println("<br>");




    
    out.println("<form name=\"uf\" action=\"edit\" method=\"post\"  >  ");
    out.println("<input style=float:right; class=\"button\" type=submit value=update>");

    out.println("</form>");
    


      
    out.println("<form name=\"uf\" action=\"remove\" method=\"post\"  >  ");
    out.println("<input style=float:right; class=\"button\" type=submit value=Delete>");
    out.println("</form>");
  }


//////Search Invalid


    if(s.equals("0"))
    {
    out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");

    String n=(String)request.getAttribute("error");
    out.println("<h1 style=\"color:red;\">  Record not found..  </h1><br>");

      
    out.println("<form name=\"uf\" action=\"newcustomer\" method=\"post\"  >  ");
    out.println("<input style=float:right;width:150px; class=\"button\" type=submit value=\"Add new Customer\">");
    out.println("</form>");

    }
    


    ////Record Update
    if(s.equals("true")){
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:green;\"> Record Updated...</h1><br>");
      
    }
    ////not Update Record
    if(s.equals("false")){
      
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:red;\"> Updation Error...  </h1><br>");
     
    }


    ////Delete
    if(s.equals("delete")){
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:green;\"> Record Deleted...</h1><br>");
      
    }
    ///Not Delete Record
    if(s.equals("not delete")){
      
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:red;\"> Deletion Error...  </h1><br>");
     
    }


    ////already present
    if(s.equals("found")){
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:red;\"> Already in Record...</h1><br>");    
      out.println("<strong> Customer ID already taken, Please change it...</strong><br>");
   
    }
    ///inserted
    if(s.equals("added")){
      
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:green;\">  Insert Successfully...  </h1><br>");
     
    }
    ///not Inserted
    if(s.equals("not added")){
      
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:red;\"> Insertion Error ...  </h1><br>");
     
    }

////order founded....
    if(s.equals("order found")){
      
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:green;\">  Order Already Present...  </h1><br>");
      out.println("<strong> Order ID already taken, Please change it...</strong><br>");
   
    }
    ///Order not Inserted
    if(s.equals("order not added")){
      
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:red;\"> Order Insertion Error ...  </h1><br>");
     
    }

    //invalid order ID input by jOptionPane.....
    if(s.equals("order false")){
      
      out.println("<fieldset style=\"width:350px; margin-left:100px;\">  ");
      out.println("<h1 style=\"color:red;\"> Invalid Order ID ...  </h1><br>");
      out.println("<strong> Please enter Valid Order ID...</strong><br>");

     
    }



  out.println("</fieldset> </div> "); //left down div
  out.println("</div>"); //left div
  out.println("</div>"); //main div
  
  out.println("</body></html>");
  






   
   

    

  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

}
