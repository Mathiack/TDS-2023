<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver Livros</title>
    <link rel="stylesheet" href="../style.css">
    <style>
        * {
            font-family: monospace;
        }

        a#voltarVerLivros {
            text-decoration: none;
            padding: 5px;
            background-color: gray;
            border-radius: 10px;
            color: white;
        }
        a#addLivroVerLivro {
            text-decoration: none;
            padding: 5px;
            background-color: gray;
            border-radius: 10px;
            color: white;
            margin-top: 10px;
        }

        div#voltaVerLivros {
            margin-top: 20px;
        }

        a.opsTable#atualizar {
            color: rgb(0, 102, 204);
            text-decoration: none;
        }

        a.opsTable#apagar {
            color: red;
            text-decoration: none;
        }

        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 4px;
        }

        a#cliqueAQ {
            text-decoration: underline;
            color: black;
        }
    </style>
</head>

<body>
    <div class="centralizado">
        <div class="titulo">
            <div id="seusLivros">
                <h1>Livros Adicionados</h1>
            </div>
            <?php
            session_start();

            include "biblioteca.class.php";
            $b = new Biblioteca();
            $livros = $b->getLivrosByIddoUser($ID_User);

            $numLivros = count($livros);
            if ($numLivros == 0) {
                echo "
                    <p>Você ainda não tem nenhum Livro!<p>
                    <p><a href='../Ops/addLivros.php' id='cliqueAQ'>Clique aqui</a> para adicionar um livro</p>
                ";
            } else {
                echo "<p>Número de Livros: <h3><strong>$numLivros</strong></h3></p>";
            ?>
                <table>
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Autor</th>
                            <th>ISBN</th>
                            <th>Editora</th>
                            <th colspan="2">Operações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        foreach ($livros as $livro) {
                        ?>
                            <tr>
                                <td><?php echo $livro['Nome']; ?></td>
                                <td><?php echo $livro['Autor']; ?></td>
                                <td><?php echo $livro['ISBN']; ?></td>
                                <td><?php echo $livro['Editora']; ?></td>
                                <td><?php echo "<a href='../Ops/apagar.php?id=" . $livro['ID_Livro'] . "' class='opsTable' id='apagar'>Apagar🚫</a>"; ?></td>
                                <td><?php echo "<a href='../Ops/att.php?id=" . $livro['ID_Livro'] . "' class='opsTable' id='atualizar'>Editar✏️</a>"; ?></td>
                            </tr>
                        <?php
                        }
                        ?>
                    </tbody>
                </table>
                <br>
                <div id="addLivroVerLivro">
                    <a href="../Ops/addLivros.php" id="addLivroVerLivro">Adicionar Livro</a>
                </div>
            <?php
            }
            ?>
            <div id="voltaVerLivros">
                <a href="index.php" id="voltarVerLivros">Voltar à Tela Inicial</a>
            </div>
        </div>
    </div>
</body>

</html>
