<%-- 
    Document   : login
    Created on : 01-May-2018, 23:25:12
    Author     : Faseih Saad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  if(session.getAttribute("email")!=null){
      out.print("<script>window.location.href='available.jsp'</script>");
  }  
%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Rent | Signup</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="pre-loader.css" rel="stylesheet" />
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="assets/css/demo.css" rel="stylesheet" /> 
    <link href="assets/css/examples.css" rel="stylesheet" /> 
        
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>

    <!-- Scripts -->
    
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
    
    <script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
    <script src="pre-loader.js" type="text/javascript"></script>
    
    <!--  Plugins -->
    <script src="assets/js/ct-paper-checkbox.js"></script>
    <script src="assets/js/ct-paper-radio.js"></script>
    <script src="assets/js/bootstrap-select.js"></script>
    <script src="assets/js/bootstrap-datepicker.js"></script>
    
    <script src="assets/js/ct-paper.js"></script>
</head>
<body>	
    <div class="pre-loader">
                <!-- Loading square for squar.red network -->
    <span class="loader"><span class="loader-inner"></span></span>
    </div>
    <style>
    .register-card{
        background-color: #66615b !important;
    }

    .title{
        color: whitesmoke !important;
    }

    .register-card{
        max-width: 90vh !important;
    }
    .register-background{
        background: url(bg.jpg) !important;
    }
    </style>
    <div class="wrapper">
        <div class="register-background"> 
            <div class="filter-black"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-10 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
                            <div class="register-card">
                                <h3 class="title">Login</h3>
                                <form class="contact-form" method = "post" action = "login_process.jsp">
                                        
                                        <div class="row">
                                           
                                                <label class="btn-tooltip" data-toggle="tooltip" data-placement="left" title="Your Email">Email</label>
                                                <input class="form-control" type="email" placeholder="Eail" name = "u_email" id = "semail"required>
                                           
                                            
                                        </div>
                                    <div class="row">
                                            
                                                <label class="btn-tooltip" data-toggle="tooltip" data-placement="left" title="Password">Password</label>
                                                <input class="form-control" type="password" name = "u_password" placeholder="Name" id = "sname" required>
                                            
           
                                        </div>
                                        <div class="row">
                                            
                                           <div class="col-md-6">
                                            <button type="submit" class="btn btn-info btn-fill btn-block" name = "submit" >Login</button>
                                        </div>
                                        <div class="col-md-6">
                                                <a class="btn btn-info btn-fill btn-block" href="index.jsp" >Signup Instead</a>
                                        </div>
                                        
                                        </div>
                                       

                                        

							
                                    </form>
                                    
                                
                            </div>
                        </div>
                    </div>
                </div>     
        </div>
    </div>      
    <script>
        $('.btn-tooltip').tooltip();
    </script>
</body>


    
</html>
