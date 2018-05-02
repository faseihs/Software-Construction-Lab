<%-- 
    Document   : rent
    Created on : 02-May-2018, 00:31:25
    Author     : Faseih Saad
--%>

<%@page import="com.sclab.car_rent_web.User"%>
<%@page import="com.sclab.car_rent_web.UserController"%>
<%@page import="com.sclab.car_rent_web.Car"%>
<%@page import="com.sclab.car_rent_web.CarController"%>

<%
  if(session.getAttribute("email")==null){
      out.print("<script>window.location.href='login.jsp'</script>");
  }  
%>  
<% 

int id =Integer.parseInt(request.getParameter("id"));
Car car =CarController.getCar(id);
car.setC_in_use(true);
car.getUser().add(UserController.getUserbyEmail((String)session.getAttribute("email")));
if(CarController.updateCar(car)){
    User user=UserController.getUserbyEmail((String)session.getAttribute("email"));
    user.getCar().add(car);
    if(UserController.updateUser(user)){
    out.print("<script>alert('Car rented')</script>");
    out.print("<script>window.location.href='available.jsp'</script>");
    }
    else{
        out.print("<script>alert('Error Renting')</script>");
    out.print("<script>window.location.href='available.jsp'</script>");
    }
}
else{
    out.print("<script>alert('Error Renting')</script>");
    out.print("<script>window.location.href='available.jsp'</script>");
}


%>
