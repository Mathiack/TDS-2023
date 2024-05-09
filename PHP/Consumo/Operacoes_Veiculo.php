<?php 
/*Criar a classe PESSOAS_BANCO (tds2023/exemplo_banco/pessoasbanco.class.php) */

include "conexao.class.php";
class Pessoas_banco {
    //criar gettes e setters

    private $veiculo;
    private $ano;
    private $placa;
    //pegando os dados

    function setVeiculo($veiculo) {
        $this->veiculo = $veiculo;
    }
    function getVeiculo() {
        return $this->veiculo;
    }

    function setAno($ano) {
        $this->ano = $ano;
    }
    function getAno() {
        return $this->ano;
    }

    function setPlaca($placa) {
        $this->placa = $placa;
    }
    function getPlaca() {
        return $this->placa;
    }

    function listarVeiculo() {
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
    }
    
    /*function deletarPessoa() {
        $database = new Conexao(); //nova instancia da conexao
        $db = $database->getConnection(); //tenta conectar

        $sql = "DELETE FROM pessoa WHERE ID_Pessoa =:ID_Pessoa";

        try {
            $stmt = $db->prepare($sql);
            $stmt->bindParam(':ID_Pessoa', $this->ID_Pessoa);
            $stmt->execute();
        } catch(PDOExeption $e) {
            echo "Erro ao deletar pessoa: " . $e->getMessage();
        }
    }*/
    function inserirVeiculo() {
        $database = new Conexao(); //nova instancia da conexao
        $db = $database->getConnection(); //tenta conectar
        
        $sql = "INSERT INTO pessoa (veiculo, ano, placa) VALUES (:veiculo, :ano, :placa)";
        try {
            $stmt = $db->prepare($sql);

            
            $stmt->bindParam(':veiculo', $this->veiculo);
            $stmt->bindParam(':ano', $this->ano);
            $stmt->bindParam(':placa', $this->placa);
            $stmt->execute();
            return true;
        } catch(PDOExeption $e) { //if(erro==true) {echo $this->mensagem;}
            echo "Erro ao inserir pessoa: " . $e->getMessage();
            return false;
        }
    /*function alterarVeiculo() {
        $database = new Conexao(); //nova instancia da conexao
        $db = $database->getConnection(); //tenta conectar

        $sql = "UPDATE pessoa SET veiculo=:veiculo; placa=:placa; ano=:ano; ";

        try {
            $stmt = $db->prepare($sql);
            $stmt->bindParam(':ID_Pessoa', $this->ID_Pessoa);
            $stmt->bindParam(':veiculo', $this->veiculo);
            $stmt->bindParam(':placa', $this->placa);
            $stmt->bindParam(':ano', $this->ano);
            $stmt->execute();
        } catch(PDOExeption $e) {
            echo "Erro ao upar novas mudanças na pessoa: " . $e->getMessage();
        }
    }*/
    }
}
    
?>