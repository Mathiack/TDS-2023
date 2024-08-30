<?php

session_start();
include "../Estante/biblioteca.class.php";
//criação de um objeto ( p )
$b =  new Biblioteca();

//puxagem do html
$nomeA = $_POST['nomeA'];
$autorA = $_POST['autorA'];
$isbnA = $_POST['isbnA'];
$editoraA = $_POST['editoraA'];
$id = $_POST['id_livro'];

//setagem

$b->setTitulo($nomeA);
$b->setAutor($autorA);
$b->setISBN($isbnA);
$b->setEditora($editoraA);
$b->setId_Livro($id);

// mensagem de inserção
$b->updateLivros();

//estilo
echo "
        <style>
            * {
                font-family: monospace;
            }
            div.centralizado > div#tabelaB {
                background-color: whitesmoke;
                padding: 20px;
                border-radius: 10px;
                text-align: center;
                text-decoration: none;
                color: black;
                font-family: monospace;
            }
            div.centralizado > div#tabelaB > a {
                text-decoration: none;
                color: black;
            }
            div.centralizado {
                 position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }
        </style>
        ";
//link para o listarPessoas.php
echo "
        <div class='centralizado'>
            <div id='tabelaB'>
                <p>Show de Bola!</p>
                <a href='../Estante/verLivros.php'>Voltar Para Os Registros</a>
            </div>
        </div>
    ";

?>