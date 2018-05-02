<%@page import="com.sclab.car_rent_web.UserController"%>  
<jsp:useBean id="obj" class="com.sclab.car_rent_web.User"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
    
boolean status=UserController.register(obj);  
if(status)  {
    session.setAttribute("email", obj.getU_email());
    session.setAttribute("id", UserController.getUserbyEmail(obj.getU_email()).getU_id());
    out.print("<script>alert('You are successfully registered')</script>");
  out.print("<script>window.location.href='available.jsp'</script>"); 
}

else {
    out.print("<script>alert('Error , Try Again')</script>");
    out.print("<script>window.location.href='index.jsp'</script>");
}
%>  