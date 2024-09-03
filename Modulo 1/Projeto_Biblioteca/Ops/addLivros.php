<?php
  session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar Livros</title>
    <link rel="stylesheet" href="../style.css">
    <style>
        * {
            font-family: monospace;
        }
        input#inputAdd {
            border-radius: 10px;
            color: white;
            border: 1px solid white;
            background-color: gray;
        }
    </style>
</head>
<body>
    <div class="centralizado">
        <div class="titulo">
            <h1>Adicionar Livro</h1>
        </div>
        <div class="adicionandoLivro">
            <form action="../Estante/biblioteca.php" method="post">
                <label for="titulo" id="titulo">
                    <b>Título</b>
                </label>
                <br>
                <input type="text" name="titulo" id="titulo" required>
                <br>

                <label for="autor" id="autor">
                    <b>Autor</b>
                </label>
                <br>
                <input type="text" name="autor" id="autor" required>
                <br>

                <label for="isbn" id="isbn">
                    <b>ISBN</b>
                </label>
                <br>
                <input type="text" name="isbn" id="isbn">
                <br>

                <label for="editoraB" id="editoraB">
                    <b>Editora</b>
                </label>
                <br>
                <input type="text" name="editoraB" id="editoraB" required>
                <br>

                <input type="submit" value="Adicionar" id="inputAdd">
            </form>
            <div id="voltarInicio">
                <a href="../Estante/index.php">Voltar à página Inicial</a>
            </div>
        </div>
    </div>
</body>
</html>