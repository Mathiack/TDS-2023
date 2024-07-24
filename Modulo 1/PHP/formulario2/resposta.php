<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fomulário</title>
</head>
<body>
    <h1>
        Teu cadastro(muinto çigema): 
    </h1>
    <?php
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $idade = $_POST['idade'];
    ?>
        <label for="nome">Nome:</label> <?php echo $nome; ?>
        <br>
        <label for="email" > E-mail:</label> <?php echo $email; ?>
        <br>
        <label for="idade">Idade:</label> <?php echo $idade; ?>
        <br>
        <input type="submit" value="Enviar">

</body>
</html>