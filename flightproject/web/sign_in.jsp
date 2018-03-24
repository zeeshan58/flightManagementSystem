<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Sign In</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/main1.css" rel="stylesheet">

</head>
<body background="back10.jpg">

  <!-- navbar -->
  <nav class="mynavbar navbar mynavbar navbar-inverse" >
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="home.jsp">AirGreen</a>
      </div>
      <ul class="nav navbar-nav navtext">
        <li class="active"><a href="home.jsp">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right navtext">
        <li><a href="sign_up.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <!--  <li><a href="sign_in.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     --> </ul>
    </div>
  </nav>
  <div class="container">
    <div class="row">
      <div class="col-md-4">
      </div>

        <div class="col-md-4">
          <div class="box">
          <div class="panel with-nav-tabs panel-default">
            <div class="panel-heading" style=" height:60px; background-color:#665851">
                  <h3 style="color:white; text-align:center; padding-bottom:20px;font-family: Trebuchet MS;">SIGN IN</h3>
            </div>
          </div>
          <div class="panel-body">
            <form method="post" action="j_security_check">

              <label >User Name</label>
              <input type="text" class="form-control" name="j_username" placeholder="">

              <label >password</label>
              <input type="password" class="form-control" name="j_password" placeholder="">
              <div class="signup-holder">
                <input type="submit" id="signInB" value="Sign In">
              </div>

          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<br/>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- <script src="bootstrap/js/jquery.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

<!--<script>
    $('#signInB').click(function() {
        $usrn = $("input:text").val();
        if($usrn=="admin"){
            window.location.href = 'admin.jsp';
        }
        else if($usrn=="manager"){
            window.location.href = 'manager.jsp';
        }
        else {
            window.location.href = 'home.jsp';
        }
        return false;
    });

</script>-->
