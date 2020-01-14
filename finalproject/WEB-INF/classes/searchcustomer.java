import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class searchcustomer extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
    HttpSession session=request.getSession(false);
    if(session==null)
    {RequestDispatcher rd=request.getRequestDispatcher("login.html");
    rd.forward(request, response);}
    
    PrintWriter out = response.getWriter();

    String id=request.getParameter("rid");
    String fname=request.getParameter("fn");
    String lname=request.getParameter("ln");
    System.out.println(id);
    System.out.println(fname);
    System.out.println(lname);
    

    String i;
    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/darzikhana";

    Connection con=DriverManager.getConnection(url,"root","zain4744");

    Statement st=con.createStatement();
    
     String query="Select * from customerdetails where customerId="+id+" and firstName='"+fname+"' and lastName='"+lname+"' ";
      System.out.println("Customer search query.........");
      System.out.println(query);
     ResultSet rs = st.executeQuery( query );
   
     
     if(rs.next()){
      i="1";
	    //out.println("<h1>Record found</h1>");

            int cid = rs.getInt("customerId");
            String fn = rs.getString("firstName");
            String ln = rs.getString("lastName");
            String mb = rs.getString("mobileNumber");
    	     String add = rs.getString("address");
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





            String rid=String.valueOf(cid);
            


            session.setAttribute("c_searchId", rid);
           // session.setAttribute("c_searchname", fn);

          //  ///Add cookies
          //  Cookie c1=new Cookie(fn,rid);
           

          //  c1.setMaxAge(30);
           

          //  response.addCookie(c1);
          
         
          
           
            

        request.setAttribute("status",new String(i));
        request.setAttribute("cid",cid);
        request.setAttribute("fn",new String(fn));
        request.setAttribute("ln",new String(ln));
        request.setAttribute("mb",new String(mb));
        request.setAttribute("add",new String(add));
        request.setAttribute("kl",kl);
        request.setAttribute("al",al);
        request.setAttribute("sh",sh);
        request.setAttribute("ch",ch);
        request.setAttribute("co",co);
        request.setAttribute("fi",fi);
        request.setAttribute("tl",tl);
        request.setAttribute("bo",bo);
        request.setAttribute("po",new String(po));
        request.setAttribute("da",new String(da));

        RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
			  rd.forward(request, response);




	  }
    
     else{
      //out.println("else");
       i="0";
     //  out.println(i);
      String err="No record found........";
      request.setAttribute("status",new String(i));
      request.setAttribute("error",new String(err));
      RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
      rd.forward(request, response);
     }   


     //out.println("</body></html>");
           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }



public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);}

}
