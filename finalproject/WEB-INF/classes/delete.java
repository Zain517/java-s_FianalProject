import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class delete extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    // HttpSession session=request.getSession(false);
    // System.out.println("session gets delete pg  :"+session);
    // if(session==null) 
    // {response.sendRedirect("/Search");}

    HttpSession session=request.getSession(false);
    System.out.println("session gets delete pg  :"+session);
    if(session==null)
    {RequestDispatcher rd=request.getRequestDispatcher("login.html");
    rd.forward(request, response);}
    else{ 
     String id=(String)session.getAttribute("c_searchId");
    System.out.println("for delete Received Id:::"+id);


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
             //Scanner inp = new Scanner(System.in);
            String query="Select * from customerdetails where customerId='"+id+"'  ";

System.out.println("deletionn query...."+query);

            PreparedStatement pst=con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = pst.executeQuery(); 
            String i;
            if(rs.next()){
                rs.deleteRow();
                i="delete";
                request.setAttribute("status",new String(i));
                RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
                rd.forward(request, response);
              }
             
             else{
                 i="not delete";
                 request.setAttribute("status",new String(i));
                 RequestDispatcher rd=request.getRequestDispatcher("/placeorder");
                 rd.forward(request, response);
                 }

    
    //  RequestDispatcher rd=request.getRequestDispatcher("login.html");
    //  rd.forward(request, response); 	
    
    
         //  st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

}
