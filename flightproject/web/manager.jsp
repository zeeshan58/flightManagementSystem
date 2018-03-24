<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Manager</title>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/main1.css" rel="stylesheet">

</head>

<body background="back10.jpg">


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>

    $(document).ready(function(){
        $(".apprId").click(function(){
           // alert("approved");
            //document.getElementById("to").value='jarawala';
            var $row = $(this).parent()   // Moves up from <button> to <td>
                .parent();  // Moves up from <td> to <tr>
            document.getElementById("approved").value="Y";
            document.getElementById("flightId").value=$row.find("td:nth-child(13)").text();
            $("form").submit();
        });
    });

    $(document).ready(function(){
        $(".rejId").click(function(){

            //document.getElementById("to").value='jarawala';
            var $row = $(this).parent()   // Moves up from <button> to <td>
                .parent();  // Moves up from <td> to <tr>
            document.getElementById("approved").value="R";
            document.getElementById("flightId").value=$row.find("td:nth-child(13)").text();
            $("form").submit();
        });
    });
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
      <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
    </ul>
  </div>
</nav>
<form method="post" action="/managerServlet">
  <input type="hidden" id="flightId" name="flightId">
  <input type="hidden" id="approved" name="approved">

</form>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="box">
          <div class="panel with-nav-tabs panel-default">
            <div class="panel-heading" style="background-color:#665851">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#tab1default" data-toggle="tab">Added Flights</a></li>


              </ul>
            </div>
          </div>
          <div class="panel-body">
            <div class="tab-content">
              <div class="tab-pane fade in active" id="tab1default">
                <table class="table table-condensed">
                  <thead>
                    <tr>
                      <th>FlightNo</th>
                      <th>From</th>
                      <th>To</th>
                      <th>Date</th>
                      <th>Departs</th>
                      <th>Duration</th>
                      <th>FC Seats</th>
                      <th>Price</th>
                      <th>BC Seats</th>
                      <th>Price</th>
                      <th>EC Seats</th>
                      <th>Price</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${flightList}" var="fList">
                    <tr>
                      <td>${fList.flightNum}</td>
                      <td>${fList.from}</td>
                      <td>${fList.to}</td>
                      <td>${fList.date}</td>
                      <td>${fList.time}</td>
                      <td>${fList.duration}</td>
                      <td>${fList.fcSeats}</td>
                      <td>${fList.fcSeatPrice}</td>
                      <td>${fList.ecSeats}</td>
                      <td>${fList.ecSeatPrice}</td>
                      <td>${fList.bcSeats}</td>
                      <td>${fList.bcSeatPrice}</td>
                      <td style="display: none">${fList.flightId}</td>
                      <td><button type="button" id="apprId" class="mybutton apprId">Approve</button>
                      <button type="button" id="rejId" class="mybutton rejId">Reject</button>
                      </td>

                    </tr>
                  </c:forEach>

                  </tbody>
                </table>
              </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  <br/>


  <!-- <script src="bootstrap/js/jquery.min.js"></script> -->
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
