<%-- 
    Document   : available
    Created on : 01-May-2018, 23:18:26
    Author     : Faseih Saad
--%>

<%@page import="com.sclab.car_rent_web.User"%>
<%@page import="com.sclab.car_rent_web.UserController"%>
<%@page import="com.sclab.car_rent_web.Car"%>
<%@page import="java.util.List"%>
<%@page import="com.sclab.car_rent_web.CarController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   
  
%>  
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Cars</title>
    </head>
    <body>
        <a href="logout.jsp">Logout</a>
    <center>
        <h3>Available Cars</h3>
        <%
             if(session.getAttribute("email")==null){
                  String redirectURL = "login.jsp";
                response.sendRedirect(redirectURL);
             }
             else{
            List<Car> list=CarController.getAvailableCars();
            out.print("<table style='padding:20px;' cellspacing='10' rowspacing='10'><tr><th>Brand</th><th>Model</th><th>Color</th><th></th></tr>");
            for(Car c : list){
                out.print("<tr><td>"+c.getC_brand()+"</td><td>"+c.getC_model()+"</td><td>"+c.getC_color()+"</td>");
                out.print("<td><a href='rent.jsp?id="+c.getC_id()+"'>Rent</a></td>");
            }
            out.print("</table>");
            
            %>
            <hr/>
            <h3>Cars Rented By You</h3>
            <%
                User user=UserController.getUserbyEmail((String)session.getAttribute("email"));
                List<Car> listc=user.getCar();
                 if(listc.isEmpty()){
                     out.println("<h3>No Cars Rented</h3>");
                 }
                 else{
                out.print("<table style='padding:20px;' cellspacing='10' rowspacing='10'><tr><th>Brand</th><th>Model</th><th>Color</th><th></th></tr>");
            for(Car c : listc){
                out.print("<tr><td>"+c.getC_brand()+"</td><td>"+c.getC_model()+"</td><td>"+c.getC_color()+"</td>");
                
            }
            out.print("</table>");
                 }
                 
}
                %>
    </center>
    </body>
</html>
