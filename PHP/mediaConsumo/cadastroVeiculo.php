<?php

    /*function listaPessoas() {
        $database = new Conexao(); //nova instancia da conexao
        $db = $database->getConnection(); //tenta conectar

        $sql = "Select * from pessoa";

        try {
            $stmt = $db->query($sql);
            $rs = $stmt->fetchAll(PDO::FETCH_ASSOC); //rs = result -> resultado  ::::: fetchAll == ecncapsula realizando o processo concatenativo em todos os itens/objetos presentes no ambiente
            return $rs;
        } catch(PDOExeption $e) {
            echo 'Erro ao listar pessoas: ' . $e->getMessage();
            $rs = [];
            return $rs;
        }
    }*/
    
    include "conexao.class.php";
    class cadastroVeiculo {

    function inserirVeiculo() {
        $database = new Conexao(); //nova instancia da conexao
        $db = $database->getConnection(); //tenta conectar
        
        $sql = "INSERT INTO VALUES veiculo (marca, modelo, kmHodometro, litrosAbastecidos, valorAbastecimento, cheio)(:marca, :modelo, :kmHodometro, :litrosAbastecidos, :valorAbastecimento, :cheio)";
        try {
            $stmt = $db->prepare($sql);

            $stmt->bindParam(':marca', $this->marca);
            $stmt->bindParam(':modelo', $this->modelo);
            $stmt->bindParam(':kmHodometro', $this->kmHodometro);
            $stmt->bindParam(':litrosAbastecidos', $this->gasolinaLitro);
            $stmt->bindParam(':valorAbastecimento', $this->valorGasolina);
            $stmt->bindParam(':cheio', $this->idade);
            $stmt->execute();
            return true;
        } catch(PDOExeption $e) { //if(erro==true) {echo $this->mensagem;}
            echo "Erro ao inserir pessoa: " . $e->getMessage();
            return false;
        }
    }
}  
?>