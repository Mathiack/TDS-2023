<?php 
    include "viagem.class.php";
    include "cadastroVeiculo.php";

    $v = new Viagem();

    $marca = $_POST['marca'];
    $v->setMarca($marca);
    $modelo = $_POST['modelo'];
    $v->setModelo($modelo);
    $kmInicial = $_POST['kmInicial'];
    $v->setKmInicial($kmInicial);
    $kmFinal = $_POST['kmFinal'];
    $v->setKmFinal($kmFinal);
    $gasolinaLitro = $_POST['gasolinaLitro'];
    $v->setGasolinaLitro($gasolinaLitro);
    $precoGasolina = $_POST['precoGasolina'];
    $v->setPrecoGasolina($precoGasolina);
    $gasolinaTipo = $_POST['gasolinaTipo'];
    $v->setGasolinaTipo($gasolinaTipo);
    /*$completoOTanque = $_POST['completoOTanque'];
    $v->setIsCOmpleto($completoOTanque);*/

    $v->imprimir();

?>