<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype HTML>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
	
<html>
    <head>
        <title>Login page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Login Or Register:</h1>
        <form action="${pageContext.request.contextPath}/authenticate" method="POST">
            Login &nbsp; <input type="radio" name="option" value="Login"> &nbsp;&nbsp;
            Register &nbsp; <input type="radio" name="option" value="Register">
            
            <br>        
            <label> Username :  </label><input type="text" name="userName" />
            <br>
            <label> Password :  </label><input type="password" name="password" />
            <br>
            <input type="submit" value="Submit"/>
        </form>
        <br/><br/><br/><br/>
    </body>
</html>
