<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrado</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
        $veiculo = $_POST['veiculo'];
        $ano = $_POST['data'];
        $placa = $_POST['placa'];

        echo "<div>Veiculo: " . $veiculo . "<br>";
        echo "Ano: " . $ano . "<br>";
        echo "Placa: " . $placa . "<br> </div>";
    ?>
    <div id="div">
        <a href="cadVeiculo.html">Voltar ao Cadastro</a>
    </div>
</body>
</html>