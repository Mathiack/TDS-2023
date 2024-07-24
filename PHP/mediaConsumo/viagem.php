<?php 
    include "viagem.class.php";

    $v = new Viagem();

    $marca = $_POST['marca'];
    $v->setMarca($marca);
    $modelo = $_POST['modelo'];
    $v->setModelo($modelo);
    $kmInicial = $_POST['kmInicial'];
    $v->setKmInicial($kmInicial);
    $kmFinal = $_POST['kmFinal'];
    $v->setKmFinal($kmFinal);
    $kmHodometro = $_POST['kmHodometro'];
    $v->setKmHodometro($kmHodometro);
    $gasolinaLitro = $_POST['gasolinaLitro'];
    $v->setGasolinaLitro($gasolinaLitro);
    $precoGasolina = $_POST['precoGasolina'];
    $v->setPrecoGasolina($precoGasolina);
    $gasolinaTipo = $_POST['gasolinaTipo'];
    $v->setGasolinaTipo($gasolinaTipo);
    /*$completoOTanque = $_POST['completoOTanque'];
    $v->setIsCOmpleto($completoOTanque);*/
    $cheio = false;

    $v->imprimir();
    if(isset($_POST['completoOTanque'])) {
        $cheio = true;
        echo "Encheu o tanque: sim<br>";
    } else {
        $cheio = false;
        echo "Encheu o tanque: não<br>";
    }
    $v->mandarVeiculo();
    $v->mandarAbastecimento();
?>