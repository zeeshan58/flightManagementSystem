<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Confirm</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/main1.css" rel="stylesheet">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <li><a href="sign_up.jsp"><span class="glyphicon glyphicon-log-out"></span> Sign Up</a></li>
        <li><a href="sign_in.jsp" type="hidden"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </nav>
  <div class="container">
    <div class="row">
      <div class="col-md-1">
      </div>
    	<div class="col-md-10">
            <div class="box">
            <div class="panel with-nav-tabs panel-default">
                <div class="panel-heading" style="background-color:#665851">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1default" data-toggle="tab">flight Itinerary</a></li>



                        </ul>
                </div>
              </div>
                <div class="panel-body">
                  <div class="row">
                    <form method="post" action="/confirmFlight">
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <label>Flight No: </label></br>
                        <input name="flightNum" value="${param.flightNum}" readonly>  </input>
                      </div>
                    <div class="col-md-4">
                      <label>From: </label></br>
                      <input name="from" value="${param.from}" readonly>  </input>
                    </div>
                    <div class="col-md-4">
                         <label>To: </label></br>
                        <input name="to" value="${param.to}" readonly>  </input>
                    </div>
                      <div class="col-md-4">
                        <label>Date: </label></br>
                        <input name="date" value="${param.date}" readonly>  </input>
                      </div>
                      <div class="col-md-4">
                        <label>Time: </label></br>
                        <input name="time" value="${param.time}" readonly>  </input>
                      </div>
                      <div class="col-md-4">
                        <label>Durtion: </label></br>
                        <input name="duration" value="${param.duration}" readonly>  </input>
                      </div>
                      <div class="col-md-4">
                        <label>Adults: </label></br>
                        <input name="adults" value="${param.adults}" readonly>  </input>
                      </div>
                      <div class="col-md-4">
                        <label>Children: </label></br>
                        <input name="children" value="${param.children}" readonly>  </input>
                      </div>
                      <div class="col-md-4">
                        <label>Infants: </label></br>
                        <input name="infants" value="${param.infants}" readonly>  </input>
                      </div>
                      <div class="col-md-4">
                        <label>Class: </label></br>
                        <input name="classOf" value="${param.classOf}" readonly>  </input>
                      </div>
                      <div class="col-md-4">
                        <label>Price per seat: </label></br>
                        <input name="price" value="${param.price}" readonly>  </input>
                        <input style="display: none" name="flightId" value="${param.flightId}">

                      </div>
                      <div class="col-md-4">
                        <input type="submit" id="confBtn" value="Confirm&Pay" style="margin-top: 20px;margin-left: 0px">
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


  <script>
  $(document).ready(function(){
  $(".mybutton").click(function(){

  var $row = $(this).parent()   // Moves up from <button> to <td>
    .parent();  // Moves up from <td> to <tr>

    document.getElementById("from").value=$row.find("td:nth-child(1)").text();
    document.getElementById("to").value=$row.find("td:nth-child(2)").text();
    document.getElementById("date").value=$row.find("td:nth-child(3)").text();
    document.getElementById("time").value=$row.find("td:nth-child(4)").text();
    document.getElementById("price").value=$row.find("td:nth-child(5)").text();
    document.getElementById("flightNum").value=$row.find("td:nth-child(6)").text();
    document.getElementById("duration").value=$row.find("td:nth-child(7)").text();
    document.getElementById("approved").value=$row.find("td:nth-child(8)").text();
    document.getElementById("class").value=${param.classOf}
    document.getElementById("adults").value=${param.adults}
    document.getElementById("children").value=${param.children}
    document.getElementById("infants").value=${param.infants}
      //$('#class1').val('Economy');
    //$('input[name="class1"]:checked').val('Economy');
    //document.getElementById("mDate").value=$row.find("td:nth-child(4)").text();
    });
    });
  </script>
</body>
</html>
