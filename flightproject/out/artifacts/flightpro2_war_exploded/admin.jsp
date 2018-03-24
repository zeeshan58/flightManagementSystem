<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Admin</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/main1.css" rel="stylesheet">

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <!-- <script src="bootstrap/js/jquery.min.js"></script> -->
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="bootstrap/js/bootstrap.min.js"></script>

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
       <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
       --> <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
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
                <li class="active"><a href="#tab1default" data-toggle="tab">Add</a></li>
                <li><a href="#tab2default" data-toggle="tab">Edit</a></li>
                <li><a href="#tab3default" data-toggle="tab">Features</a></li>
                <li><a href="#tab4default" data-toggle="tab">Add Features</a></li>


              </ul>
            </div>
          </div>
          <div class="panel-body">
            <div class="tab-content">
              <div class="tab-pane fade in active" id="tab1default">
                <form method="post" action="/flightServlet">
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label>Flight Number</label>
                      <input type="text" class="form-control" name="number" pattern="[A-Za-z]+[0-9]+" title="Letters+numbers" required>
                    </div>
                  </div>

                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">From</label><br>

                      <input type="text" pattern="[A-Za-z]+" title="Letters only" class="form-control" name="from" required>
                    </div>
                  </div>

                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">To</label><br>

                      <input type="text"  class="form-control" name="to" pattern="[A-Za-z]+" title="Letters only" required >
                    </div>
                  </div>

                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">Date</label>
                      <input type="date" class="form-control" name="date" required >
                    </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">Departure Time</label><br>

                      <input type="time" class="form-control" name="time" required >
                    </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">Duration(hours)</label><br>
                      <input type="number"  class="form-control" name="duration" required >

                    </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">No of First Class Seats</label><br>

                      <input type="number"  class="form-control" name="nfcSeats" required >
                    </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">No of Business Class Seats</label><br>

                      <input type="number"  class="form-control" name="nbcSeats" required >
                    </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">No of Economy Class Seats</label><br>

                      <input type="number"  class="form-control" name="necSeats" required >
                    </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">First Class Price</label><br>

                      <input type="number"   class="form-control" name="fcPrice" required >
                    </div>
                  </div>

                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">Business Class Price</label><br>

                      <input type="number"  class="form-control" name="bcPrice" required >
                      <input id="adminbutton" type="submit" name="submit" value="ADD" class="btn-login">
                    </div>
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="form-group">
                      <label for="">Economy Class Price</label><br>

                      <input type="number" required pattern="[0-9]" class="form-control" name="ecPrice" placeholder="" >
                    </div>
                  </div>
                </form>
              </div>
              <div class="tab-pane fade" id="tab2default">
              <table class="table table-condensed">
                  <thead>
                    <tr>
                      <th>Flight No</th>
                      <th>From</th>
                      <th>To</th>
                      <th>Date</th>
                      <th>Departs</th>

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
                      <td style="display: none">${fList.fcSeats}</td>
                      <td style="display: none">${fList.fcSeatPrice}</td>
                      <td style="display: none">${fList.ecSeats}</td>
                      <td style="display: none">${fList.ecSeatPrice}</td>
                      <td style="display: none">${fList.bcSeats}</td>
                      <td style="display: none">${fList.bcSeatPrice}</td>
                      <td style="display: none">${fList.duration}</td>
                      <td style="display: none">${fList.flightId}</td>
                      <td><button class="mybutton">edit</button></td>

                    </tr>
                  </c:forEach>
                  </tbody>
                </table>

                <!-- code for popup box -->
                <div id="myModal" class="modal">

                  <!-- Modal content -->
                  <div class="modal-content">
                    <span class="close">&times;</span>
                    <div class="row">
                    <form method="post" action="/updateData">
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label>Flight Number</label>
                          <input type="text"  class="form-control" id="mNumber" name="mNumber" required>
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label for="">From</label><br>
                          <input type="text" class="form-control" id="mFrom" name="mFrom" required>
                        </div>
                      </div>

                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label for="">To</label><br>
                          <input type="text" class="form-control" id="mTo" name="mTo" required>
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label for="">Date</label>
                          <input type="date"  class="form-control" id="mDate" name="mDate" required>
                        </div>
                      </div>

                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label for="">Departure Time</label><br>
                          <input type="time"  class="form-control" id="mTime" name="mTime" required>
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label for="">Duration(hours)</label><br>
                          <input type="number"  class="form-control" id="mDuration" name="mDuration" required>
                        </div>
                      </div>

                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label>No of First Class Seats</label><br>
                          <input type="number"  class="form-control" id="mFcSeats" name="mFcSeats" required>
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label >No of Business Class Seats</label><br>
                          <input type="number"  class="form-control" id="mBcSeats" name="mBcSeats" required>
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label>No of Economy Class Seats</label><br>
                          <input type="number"  class="form-control" id="mEcSeats" name="mEcSeats" required>
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label for="">First Class Price</label><br>
                          <input type="number"  class="form-control" id="mFcSeatPrice" name="mFcSeatPrice" required>
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label>Business Class Price</label><br>

                          <input type="number"  class="form-control" id="mBcSeatPrice" name="mBcSeatPrice" required>
                          <input type="submit" name="submit" value="Save" class="btn-login">
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                        <div class="form-group">
                          <label>Economy Class Price</label><br>
                          <input type="number"  class="form-control" id="mEcSeatPrice" name="mEcSeatPrice" required>
                        </div>
                        <input type="text" style="display: none" id="pFlightNum" name="pFlightNum">
                        <input type="text" style="display: none" id="pDate" name="pDate">
                        <input type="text" style="display: none" id="pTime" name="pTime">
                        <input type="text" style="display: none" id="flightId" name="flightId">
                      </div>



                    </form>
                  </div>

                </div>
              </div>
            </div>
              <div class="tab-pane fade" id="tab3default">
                <div class="container">
                  <div class="row">

                    <div class="col-md-9">
                      <div class="panel with-nav-tabs panel-default">
                        <div class="panel-heading" style="background-color:#665851">
                          <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1info" data-toggle="tab">Business Class</a></li>
                            <li><a href="#tab2info" data-toggle="tab">First Class</a></li>
                            <li><a href="#tab3info" data-toggle="tab">Economy Class</a></li>
                          </ul>
                        </div>
                        <div class="panel-body">
                          <div class="tab-content">
                            <div class="tab-pane fade in active" id="tab1info">

                              <table class="table table-condensed">
                                <thead>
                                <tr>
                                  <th>Feature</th>
                                  <th>Description</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${businessFeatures}" var="featureList">
                                  <tr>
                                    <td>${featureList.name}</td>
                                    <td>${featureList.desc}</td>
                                    <td style="display: none">${featureList.id}</td>
                                    <td style="display: none">${featureList.classOf}</td>
                                    <td><button class="featureBtn">edit</button></td>
                                    <td><button class="deleteBtn">delete</button></td>

                                  </tr>
                                </c:forEach>
                                </tbody>
                              </table>
                            </div>
                            <div class="tab-pane fade" id="tab2info">

                              <table class="table table-condensed">
                                <thead>
                                <tr>
                                  <th>Feature</th>
                                  <th>Description</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${firstFeatures}" var="featureList1">
                                  <tr>
                                    <td>${featureList1.name}</td>
                                    <td>${featureList1.desc}</td>
                                    <td style="display: none">${featureList1.id}</td>
                                    <td style="display: none">${featureList1.classOf}</td>
                                    <td><button class="featureBtn">edit</button></td>
                                    <td><button class="deleteBtn">delete</button></td>

                                  </tr>
                                </c:forEach>
                                </tbody>
                              </table>

                            </div>
                            <div class="tab-pane fade" id="tab3info">

                              <table class="table table-condensed">
                                <thead>
                                <tr>
                                  <th>Feature</th>
                                  <th>Description</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${economyFeatures}" var="featureList2">
                                  <tr>
                                    <td>${featureList2.name}</td>
                                    <td>${featureList2.desc}</td>
                                    <td style="display: none">${featureList2.id}</td>
                                    <td style="display: none">${featureList2.classOf}</td>
                                    <td><button class="featureBtn">edit</button></td>
                                    <td><button class="deleteBtn">delete</button></td>

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
              </div>
              <div class="tab-pane fade" id="tab4default">
                <form id="buttonGroupForm" method="post" class="form-horizontal" action="/addFeature">
                  <div class = "form-group">
                  <div class="control-label col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <label>Class</label>
                  </div>
                    <div class="control-label col-xs-1 col-sm-1 col-md-1 col-lg-1">
                    </div>
                  <div class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4">
                      <div class="btn-group" data-toggle="buttons">
                        <label class="btn btn-default">
                          <input type="radio" name="class" value="Economy" checked /> Economy
                        </label>
                        <label class="btn btn-default">
                          <input type="radio" name="class" value="First" /> First
                        </label>
                        <label class="btn btn-default">
                          <input type="radio" name="class" value="Business" /> Business
                        </label>
                      </div><br>
                    </div>
                  <div class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4">
                  </div>
                  </div>
                    <div class="control-label col-xs-3 col-sm-3 col-md-3 col-lg-3">
                      <label >Feature Name</label>
                    </div>
                    <div class="control-label col-xs-7 col-sm-7 col-md-7 col-lg-7">
                      <input type="text" pattern="[A-Za-z]+" title="Letters only" class="form-control" name="name" required>
                    </div>
                    <div class="control-label col-xs-3 col-sm-3 col-md-3 col-lg-3">
                      <label >Description</label>
                    </div>
                    <div class="control-label col-xs-7 col-sm-7 col-md-7 col-lg-7">
                      <input type="text" class="form-control" name="desc" required>
                    </div>
                    <div class="form-group col-xs-5 col-sm-5 col-md-5 col-lg-5">
                    </div>
                    <div class="form-group col-xs-1 col-sm-2 col-md-3 col-lg-3">
                      <div class="signup-holder">
                        <input type="submit" name="" value="ADD">
                      </div>
                    </div>

                </form>
              </div>
            </div>
        </div>
      </div>
    </div>
  </div>
  <br/>

  <form id="d_form" method="post" action="/deleteFeature">

    <input type="hidden" name="d_id" id="d_id">
    <input type="hidden" name="d_name" id="d_name">
    <input type="hidden" name="d_desc" id="d_desc">
  </form>
  <script>
  // Get the modal
  var modal = document.getElementById('myModal');
  var featureModal = document.getElementById('featureModal');
  // Get the button that opens the modal
  //var btn = document.getElementsByClassName("mybutton");

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];

  // When the user clicks the button, open the modal
  /*btn.onclick = function() {
    modal.style.display = "block";
  }*/

  /*$('mbutton').click(function() {

      modal.style.display="block";
      //var id = $(this).closest("tr").find(".nr").text();
      //$("#resultas").append(id);
  });*/
  // When the user clicks on <span> (x), close the modal
  span.onclick = function() {
    modal.style.display = "none";
  }

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }

  $(document).ready(function(){
      $(".featureBtn").click(function(){
          $("#featureModal").modal();

          //$("input[name=class1][value='Economy']").attr('checked', 'checked');
          //$( "#x" ).prop( "checked", true );
          //$('input:radio[name=class1]')[1].checked = true;
          //$('#b').prop( "checked", true );

          var $row = $(this).parent()   // Moves up from <button> to <td>
              .parent();  // Moves up from <td> to <tr>
          //alert($row.find("td:nth-child(1)").text());
         // document.getElementById("mNumber").value=$row.find("td:nth-child(1)").text();
          document.getElementById("featureName").value=$row.find("td:nth-child(1)").text();
          document.getElementById("desc").value=$row.find("td:nth-child(2)").text();
          document.getElementById("_id").value=$row.find("td:nth-child(3)").text();

          //$('#class1').val('Economy');
          //$('input[name="class1"]:checked').val('Economy');
          //document.getElementById("mDate").value=$row.find("td:nth-child(4)").text();
      });
  });
  $(document).ready(function(){
      $(".deleteBtn").click(function(){

         // alert("hellllllo")
          var $row = $(this).parent()   // Moves up from <button> to <td>
              .parent();  // Moves up from <td> to <tr>
          //alert($row.find("td:nth-child(1)").text());
          // document.getElementById("mNumber").value=$row.find("td:nth-child(1)").text();
          document.getElementById("d_name").value=$row.find("td:nth-child(1)").text();
          document.getElementById("d_desc").value=$row.find("td:nth-child(2)").text();
          document.getElementById("d_id").value=$row.find("td:nth-child(3)").text();

          document.getElementById("d_form").submit();
      });
  });

  $(document).ready(function() {
      $(".mybutton").click(function () {
          modal.style.display = "block";
          var $row = $(this).parent()   // Moves up from <button> to <td>
              .parent();  // Moves up from <td> to <tr>
          //alert($row.find("td:nth-child(1)").text());
          document.getElementById("mNumber").value=$row.find("td:nth-child(1)").text();
          document.getElementById("pFlightNum").value=$row.find("td:nth-child(1)").text();
          document.getElementById("mFrom").value=$row.find("td:nth-child(2)").text();
          document.getElementById("mTo").value=$row.find("td:nth-child(3)").text();
          document.getElementById("mDate").value=$row.find("td:nth-child(4)").text();
          document.getElementById("pDate").value=$row.find("td:nth-child(4)").text();
          document.getElementById("mTime").value=$row.find("td:nth-child(5)").text();
          document.getElementById("pTime").value=$row.find("td:nth-child(5)").text();
          document.getElementById("mFcSeats").value=$row.find("td:nth-child(6)").text();
          document.getElementById("mFcSeatPrice").value=$row.find("td:nth-child(7)").text();
          document.getElementById("mEcSeats").value=$row.find("td:nth-child(8)").text();
          document.getElementById("mEcSeatPrice").value=$row.find("td:nth-child(9)").text();
          document.getElementById("mBcSeats").value=$row.find("td:nth-child(10)").text();
          document.getElementById("mBcSeatPrice").value=$row.find("td:nth-child(11)").text();
          document.getElementById("mDuration").value=$row.find("td:nth-child(12)").text();
          document.getElementById("flightId").value=$row.find("td:nth-child(13)").text();
      });
  });
  </script>

  </div>

  <div class="container">
    <!-- Trigger the modal with a button -->
    <!-- <button type="button" class="btn btn-info btn-lg" id="featureBtn">Open Modal</button>-->

    <!-- Modal -->
    <div class="modal fade" id="featureModal" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">

          <div class="modal-body">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <div class="row">
            <form id="buttonGroupForm1" method="post" class="form-horizontal" action="/updateFeature">
              <div class = "form-group">
                <div class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4">
                  <label>Class</label>
                </div>
                <div class="control-label col-xs-7 col-sm-7 col-md-7 col-lg-7">
                  <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-default">
                      <input type="radio" name="class1" id="e" value="Economy" checked/> Economy
                    </label>
                    <label class="btn btn-default">
                      <input type="radio" name="class1" id="f" value="First" /> First
                    </label>
                    <label class="btn btn-default">
                      <input type="radio" name="class1" id="b" value="Business" /> Business
                    </label>
                  </div><br>
                </div>

              </div>
              <div class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <label >Feature Name</label>
              </div>
              <div class="control-label col-xs-8 col-sm-8 col-md-8 col-lg-8">
                <input type="text" class="form-control" name="featureName" id="featureName" required>
              </div>
              <div class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <label >Description</label>
              </div>
              <div class="control-label col-xs-8 col-sm-8 col-md-8 col-lg-8">
                <input type="text" class="form-control" name="desc" id="desc" required>
                <input style="display: none" type="text" class="form-control" name="_id" id="_id">
                <input style="display: none" type="text" class="form-control" name="classOf" id="classOf">
              </div>
              <div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
              </div>
              <div class="form-group col-xs-1 col-sm-2 col-md-3 col-lg-3">
                <div class="signup-holder">
                  <input type="submit" id="featureSave" value="Save">
                </div>
              </div>

            </form>
          </div>
          </div>
        </div>

      </div>
    </div>

  </div>
</body>
</html>
