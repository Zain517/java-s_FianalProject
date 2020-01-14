import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class orderdelete extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    HttpSession session=request.getSession(false);
    if(session==null) 
    {response.sendRedirect("login.html");}

    else{ 

    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    String input = JOptionPane.showInputDialog("Enter Valid Order-ID for Deletion....\n");
    

   

    try{

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/darzikhana";
        Connection con=DriverManager.getConnection(url,"root","zain4744");
             //Scanner inp = new Scanner(System.in);
        
            PreparedStatement pst=con.prepareStatement("Select * from orderdetails where orderId='"+input+"'   ",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

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
                 i="order false";
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
    doPost(request,response);}

}
