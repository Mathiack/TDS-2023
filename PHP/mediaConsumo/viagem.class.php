<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Veiculo</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
        class Viagem {

            public $marca, $modelo, $kmInicial, $kmFinal, $gasolinaLitro, $gasolinaTipo, $media, $kmHodometro, $precoGasolina;

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

            public function setPrecoGasolina($precoGasolina) {
                $this->precoGasolina = $precoGasolina;
            }
            public function getPrecoGasolina() {
                return $this->precoGasolina;
            }

            public function setGasolinaTipo($gasolinaTipo) {
                $this->gasolinaTipo = $gasolinaTipo;
            }
            public function getGasolinaTipo() {
                return $this->gasolinaTipo;
            }

            public function imprimir() {

                $kmHodometro = $this->getKmFinal() - $this->getkmInicial();
                $valorGasolina = $this->getGasolinaLitro() * $this->getPrecoGasolina();
                $media = ($this->getkmFinal() - $this->getkmInicial()) / $this->getGasolinaLitro();
                echo "<h1>Cadastro: </h1>";
                echo "Marca: " . $this->getMarca() . "<br>";
                echo "Modelo: " . $this->getModelo() . "<br>";
                echo "Km Inicial: " . $this->getkmInicial() . "<br>";
                echo "Km Final: " . $this->getKmFinal() . "<br>";
                echo "Litros: " . $this->getGasolinaLitro() . "<br>";
                echo "Tipo da Gasosa: " . $this->getGasolinaTipo() . "<br>";
                echo "Preço da Gasolina: " . $this->getPrecoGasolina() . "<br>";
                $cheio = false;
                if(isset($_POST['completoOTanque'])) {
                    $cheio = true;
                    echo "Encheu o tanque: sim<br>";
                } else {
                    $cheio = false;
                    echo "Encheu o tanque: não<br>";
                }
                echo "Media: " . $media . "<br>";
            }
        }  
    ?>
</body>
</html>