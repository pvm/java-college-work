<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Sistema de gerenciamento da biblioteca da UPIS">
    <meta name="author" content="Philippe Vanzin Moreira">

    <title>UPIS - Sistema de Biblioteca</title>

    <!-- Bootstrap core CSS -->
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./assets/css/custom.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <form class="form-signin" method="POST" action="login">
        <h2 class="form-signin-heading">Autenticação</h2>

        <label for="email" class="sr-only">E-mail</label>
        <input type="email" name="email" id="email" class="form-control" placeholder="E-mail" required autofocus>

        <label for="password" class="sr-only">Senha</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Senha" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
    </form>

</div> <!-- /container -->
</body>
</html>

