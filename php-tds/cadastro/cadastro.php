<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fomulário</title>
</head>
<body>
    <h1>
        Vamo fazer teu cadastro(moito macho alfa):
    </h1>
    <?php
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $idade = $_POST['idade'];
    $celular = $_POST['celular'];
    $hora = $_POST['hora'];
    $site = $_POST['site'];
    $senha = $_POST['senha'];
    $nascimento = $_POST['nascimento'];
    $cor = $_POST['cor'];
    $filhos = $_POST['filhos'];
    $peso = $_POST['peso'];
    $sexo = $_POST['sexo'];
    $estado = $_POST['estado'];
    $estadoSEILA = $_POST['estadoSEILA'];
    $estadoRS = $_POST['estadoRS'];
    $mensagem = $_POST['mensagem'];
    ?>
        <label for="nome">Nome:</label> <?php echo $nome; ?>
        <br>

        <label for="email" > E-mail:</label> <?php echo $email; ?>
        <br>

        <label for="idade">Idade:</label> <?php echo $idade; ?>
        <br>

        <label for="celular">Celular com DDD:</label> <?php echo $celular; ?>
        <br>

        <label for="hora">Celular com DDD:</label> <?php echo $hora; ?>
        <br>

        <label for="site">Teu site</label> <?php echo $site; ?>
        <br>

        <label for="senha">Tua senha he he :</label> <?php echo $senha; ?>
        <br>

        <label for="nascimento">Data de Nassimento:</label> <?php echo $nascimento; ?>
        <br>

        <label for="cor">Cor que tu gosta</label> <?php echo $cor; ?>
        <br>

        <label for="filhos">Qoantos fileos tu tem</label> <?php echo $filhos; ?>
        <br>

        <label for="peso">teu pezo</label> <?php echo $peso; ?>
        <br>

        <label for="sexo">teu secso<br>Masculino</label> <?php echo $sexo; ?>
        <br>

        <label for="sexo">Feminino</label> <?php echo $sexo; ?>
        <br>

        <label for="estado">Estado</label> <?php echo $estado; ?>

        <label for="mensagem">tua memçagen</label> <?php echo $mensagem; ?>
        <br>

</body>
</html>