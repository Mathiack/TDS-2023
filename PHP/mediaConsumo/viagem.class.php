<?php
class Viagem {

    public $marca, $modelo, $kmInicial, $kmFinal, $gasolinaLitro, $gasolinaTipo, $media;

    public function setMarca($marca) {
        $this->marca = $marca;
    }
    public function getMarca() {
        return $this->marca;
    }

    public function setModelo($modelo) {
        $this->modelo = $modelo;
    }
    public function getModelo() {
        return $this->modelo;
    }

    public function setKmInicial($kmInicial) {
        $this->kmInicial = $kmInicial;
    }
    public function getkmInicial() {
        return $this->kmInicial;
    }

    public function setKmFinal($kmFinal) {
        $this->kmFinal = $kmFinal;
    }
    public function getKmFinal() {
        return $this->kmFinal;
    }

    public function setGasolinaLitro($gasolinaLitro) {
        $this->gasolinaLitro = $gasolinaLitro;
    }
    public function getGasolinaLitro() {
        return $this->gasolinaLitro;
    }

    public function setGasolinaTipo($gasolinaTipo) {
        $this->gasolinaTipo = $gasolinaTipo;
    }
    public function getGasolinaTipo() {
        return $this->gasolinaTipo;
    }
    

    public function imprimir() {

        $kmHodometro = $kmFinal - $kmInicial;
        $valorGasolina = $gasolinaLitro * $precoGasolina;
        $media = ($this->getkmFinal() - $this->getkmInicial()) / $this->getGasolinaLitro();

        echo "Marca: " . $this->getMarca() . "<br>";
        echo "Modelo: " . $this->getModelo() . "<br>";
        echo "Km Inicial: " . $this->getkmInicial() . "<br>";
        echo "Km Final: " . $this->getKmFinal() . "<br>";
        echo "Litros: " . $this->getGasolinaLitro() . "<br>";
        echo "Tipo da Gasosa: " . $this->getGasolinaTipo() . "<br>";

        echo "Media: " . $media . "<br>";
    }
}  
?>