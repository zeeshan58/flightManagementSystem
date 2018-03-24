<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Search Result</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/main1.css" rel="stylesheet">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>
<body background="back10.jpg">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script>

    $(document).ready(function(){
    $("#confBtn").click(function(){

        //document.getElementById("to").value='jarawala';
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

        //var $a=<%request.getParameter("ClassOf");%>
       // $('#class').val(<%request.getParameter("ClassOf");%>);
        //$('#adults').val($param.adults);
        //$('#children').val($param.children);
        //$('#infants').val($param.infants);
        //$('#class').val($param.classOf);
        document.getElementById("class").value=$row.find("td:nth-child(9)").text();
        document.getElementById("adults").value=$row.find("td:nth-child(10)").text();
        document.getElementById("children").value=$row.find("td:nth-child(11)").text();
        document.getElementById("infants").value=$row.find("td:nth-child(12)").text();
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
      <li><a href="/logout"><span class="glyphicon glyphicon-user"></span> Sign Out</a></li>
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
              <li class="active"><a href="#tab1default" data-toggle="tab">search results</a></li>



            </ul>
          </div>
        </div>
        <div class="panel-body">
          <table class="table table-condensed">
            <thead>
            <tr>
              <th>Departs</th>
              <th>Arrives</th>
              <th>Date</th>
              <th>Time</th>
              <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sFlightList}" var="fList">
              <tr>
                <td>${fList.from}</td>
                <td>${fList.to}</td>
                <td>${fList.date}</td>
                <td>${fList.time}</td>

                <c:if test="${param.classOf=='Economy Class'}">
                  <td>${fList.ecSeatPrice}</td>
                </c:if>
                <c:if test="${param.classOf=='Business Class'}">
                  <td>${fList.bcSeatPrice}</td>
                </c:if>
                <c:if test="${param.classOf=='First Class'}">
                  <td>${fList.fcSeatPrice}</td>
                </c:if>

                <td style="display: none">${fList.flightNum}</td>
                <td style="display: none">${fList.duration}</td>
                <td style="display: none">${fList.approved}</td>
                <td style="display: none">${param.classOf}</td>
                <td style="display: none">${param.adults}</td>
                <td style="display: none">${param.children}</td>
                <td style="display: none">${param.infants}</td>
                <td style="display: none">${fList.flightId}</td>


                <!--<td><button class="mybutton" id="confBtn" onclick="javascript:myButtonFun()" >book</button></td>
                --><td><button class="mybutton" id="confBtn" >book</button></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<br/>

<form id="okFlight" method="POST" action="confirm.jsp">
  <input type="hidden"  name="from" id="from" value="">
  <input type="hidden" name="to" id="to" value="">
  <input type="hidden" name="date" id="date" value="param1Value">
  <input type="hidden" name="time" id="time" value="param1Value">
  <input type="hidden" name="classOf" id="class" value="param1Value">
  <input type="hidden" name="adults" id="adults" value="param1Value">
  <input type="hidden" name="children" id="children" value="param1Value">
  <input type="hidden" name="infants" id="infants" value="param1Value">
  <input type="hidden" name="price" id="price" value="param1Value">
  <input type="hidden" name="flightNum" id="flightNum" value="param1Value">
  <input type="hidden" name="approved" id="approved" value="param1Value">
  <input type="hidden" name="duration" id="duration" value="param1Value">
  <input type="hidden" name="flightId" id="flightId" value="param1Value">
  <!--<input type="submit" style="display: none">
  <A HREF="javascript:document.submitForm.submit()">Click Me</A>-->
</form>


<script>
/*
    function myButtonFun()
    {
        alert("hello");
        document.getElementById('to').value='jarawala';
    }
    document.getElementById("c1onfBtn").onclick()
    {
        document.getElementById('to').value='jarawala';
    }
    // $(document).ready(function(){
    $("#").click(function(){

        var $row = $(this).parent()   // Moves up from <button> to <td>
            .parent();  // Moves up from <td> to <tr>

        document.getElementById("from").value=$row.find("td:nth-child(1)").text();
        //document.getElementById("to").value=$row.find("td:nth-child(2)").text();
        document.getElementById("to").value='jarawala';
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
        document.getElementById("infants").value=0;
        document.getElementById("okFlight").submit();
        //$('#class1').val('Economy');
        //$('input[name="class1"]:checked').val('Economy');
        //document.getElementById("mDate").value=$row.find("td:nth-child(4)").text();
    });
    //  });
    */
</script>

<!-- <script src="bootstrap/js/jquery.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
