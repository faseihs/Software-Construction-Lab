<%@page import="com.sclab.car_rent_web.Admin"%>
<%@page import="com.sclab.car_rent_web.Car"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.sclab.car_rent_web.User"%>  

<jsp:useBean id="obj" class="com.sclab.car_rent_web.User"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
    Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(User.class).addAnnotatedClass(Car.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
    
User user=(User)ses.createQuery("From User where u_email = :email AND u_password=:pass").setString("email", obj.getU_email()).setString("pass",obj.getU_password()).uniqueResult();
if(user==null){
    out.print("<script>alert('Error , Try Again')</script>");
    out.print("<script>window.location.href='login.jsp'</script>");
}
else{
    session.setAttribute("email", obj.getU_email());
    session.setAttribute("id", obj.getU_id());
     out.print("<script>alert('Logged in')</script>");
    out.print("<script>window.location.href='available.jsp'</script>");
}
%>  