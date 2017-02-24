<html>
    <head>
        <link href="resources/css/style.css" rel="stylesheet" >
    </head>
    <body class="backgroundImage">
        <div class="login">
            <h1 >Login</h1>
            <form  action="login" method="POST">
                <div class="autentification" >
                    <input type="text" name="username" placeholder="Username"   /> ${errorNume}
                </div>
                <div class="autentification">
                    <input type="password" name="password" placeholder="Password"  />${errorAutentificare}
                </div>
                <div id="logButton">
                    <input type="submit" value="Log in" />
                </div>
            </form> 
            <p>${errorParola}</p>
        </div>
    </body>
</html>