<?php
include "pessoa.class.php";

    $p->setIdade($idade);
    echo "Pessoa: ". $p->getNome() ." <br> Idade: ". $p->getIdade() . "<br>";

    $p->setNome("João");
    echo "<br>" . $p->tudo();

    $p->tudo();
    
?>