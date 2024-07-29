<?php

include_once "../Cadastro/sessao.php";
include "biblioteca.class.php";

//criação de um objeto ( b )
$b = new Biblioteca();

$id = $_POST['id'];
$nome = $_POST['nome'];
$autor = $_POST['autor'];
$isbn = $_POST['isbn'];
$editora = $_POST['editora'];

//setagem
$b->setId_LivroA($id);
$b->setTituloA($nome);
$b->setAutorA($tituloLivroA);
$b->setISBNa($isbn);
$b->setEditoraA($editora);

echo "<link rel='stylesheet' href='../style.css'>";

// mensagem de inserção
if ($p->updateLivros()) {
    echo "<div class='link'>Livro atualizado com sucesso!</div> <br>";
} else {
    echo "<div class='link'>Erro ao atualizar livro.</div> <br>";
}
echo "
<div class='link'>
<a href='verLivros.php'>TABELA LIVROS</a>
</div>
"

?>