<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Home</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/main1.css" rel="stylesheet">

</head>
<body >

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

  /*  $( document ).ready(function() {
        console.log( "ready!" );
        $("#_login").hide();
        $("#_logout").show();
    });*/
</script>
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
        <%HttpSession session1 = request.getSession(false);
          if (session1.getAttribute("user") == null) {
        %>
        <li><a href="/LoginServlet" id="_login"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
        <% }else {%>
        <li><a href="/logout" id="_logout"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
        <%}%>
      </ul>
    </div>
  </nav>
<!-- slider -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="1.jpg" alt="Los Angeles">
      </div>

      <div class="item">
        <img src="2.jpg" alt="Chicago">
      </div>

      <div class="item">
        <img src="3.jpg" alt="New York">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <!-- other body -->
  <div class="container">
    <div class="row">
      <div class="bookflight">
        <form action="/showResult" method="get">
          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
            <div class="form-group">
              <label for="">From</label>
              <input id="" type="text" title="" class="form-control" name="from" placeholder="City or Airport">
            </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
            <div class="form-group">
              <label for="">To</label>
              <input id="" type="text" title="" class="form-control" name="to" placeholder="City or Airport">
            </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
            <div class="form-group">
              <label for="">Departuring</label>
              <input id="" type="date" title="" class="form-control" name="depDate" placeholder="City or Airport">
            </div>
          </div>
         <!-- <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
            <div class="form-group">
              <label for="">Returning</label>
              <input id="" type="date" title="" class="form-control" name="" placeholder="City or Airport">
            </div>
          </div>-->
          <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
            <div class="form-group">
              <label for="">Adults</label>
              <select class="form-control" id="" name="adults">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
                <option>15</option>
              </select>
            </div>
          </div>
          <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
            <div class="form-group">
              <label for="">Children</label>
              <select class="form-control" id="" name="children">
                <option>0</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
                <option>15</option>
              </select>
            </div>
          </div>
          <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
            <div class="form-group">
              <label for="">Infants</label>
              <select class="form-control" id="" name="infants">
                <option>0</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
                <option>15</option>
              </select>
            </div>
          </div>
          <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
            <div class="form-group">
              <label for="">Class</label>
              <select class="form-control" id="" name="classOf">
                <option>Economy Class</option>
                <option>Business Class</option>
                <option>First Class</option>
              </select>
          </div>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
          <div class="bookflight-holder">
            <input type="submit" name="" value="Search" >
          </div>
          </div>


        </form>

    </div>
  </div>

    <!-- <script src="bootstrap/js/jquery.min.js"></script>-->
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script src="bootstrap/js/bootstrap-slider.js"></script>
</body>
</html>
