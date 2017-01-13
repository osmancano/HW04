<!DOCTYPE html>
<html lang="en">
<head>
    <title>TIY, HW04</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function(){
            var frm = $('#myForm');
            frm.submit(function (ev) {
                ev.preventDefault();
                var year = document.forms["myForm"]["year"].value;
                year = year.trim();
                if (isNaN(year) || year == "" || year == null || year < 0) {
                    alert("Year must be a positive number.");
                    return false;
                }
                $.ajax({
                    type: frm.attr('method'),
                    url: frm.attr('action'),
                    data: frm.serialize(),
                    success: function (data) {
                        $("#subDiv").html(data);
                    }
                });
            });
            $("#getAllLeapYears").click(function (ev) {
                ev.preventDefault();
                $.post("http://localhost:9090/allLeapYears",{}, function(data){
                    $("#subDiv").html(data);
                } );
            });
        });
    </script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="http://localhost:9090/">Home</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="http://localhost:9090/graduate">number of Days to Graduation</a></p>
            <p><a href="http://localhost:9090/leapYear.jsp">Leap year check</a></p>
            <p><a href="http://localhost:9090/ageInDays.jsp">Age in Days</a></p>
        </div>
        <div id="MainDiv" class="col-sm-10 text-left">
            <br>
            <h2>Leap year Form:</h2>
            <form action="http://localhost:9090/leap" method="post" id="myForm">
                <table>
                    <tr>
                        <td>Enter a Year:</td>
                        <td><input type="text" name="year"></td>
                    </tr>
                </table>
                <br>
                <p><input type="submit" value="Check"></p>
            </form>
            <br>
            <div id="subDiv"></div>
            Click <a href="" id="getAllLeapYears">here</a> to get all Leap years between 0 and 3000
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

</body>
</html>
