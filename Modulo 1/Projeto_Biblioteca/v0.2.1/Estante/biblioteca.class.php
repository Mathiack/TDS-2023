<?php 
    //include "biblioteca.php";
    include "../conexao.php";
    if (!isset($_SESSION['ID_User'])) {
        header('Location: login.php');
        exit();
    }
    
    $ID_User = $_SESSION['ID_User'];
    class Biblioteca {
        private $id_usuario;
        public $id_Livro, $id_Livro2, $tituloLivro, $autorLivro, $ISBN, $editora, $estado;
        private $tituloLivroA, $autorLivroA, $ISBNa, $editoraA;

        public function setId_Livro($id_Livro) {
            $this->id_Livro = $id_Livro;
        }
        public function getId_Livro() {
            return $this->id_Livro;
        }

        public function setId_Livro2($id_Livro2) {
            $this->id_Livro2 = $id_Livro2;
        }
        public function getId_Livro2() {
            return $this->id_Livro2;
        }

        public function setTitulo($tituloLivro) {
            $this->tituloLivro = $tituloLivro;
        }
        public function getTitulo() {
            return $this->tituloLivro;
        }

        public function setAutor($autorLivro) {
            $this->autorLivro = $autorLivro;
        }
        public function getAutor() {
            return $this->autorLivro;
        }

        public function setISBN($ISBN) {
            $this->ISBN = $ISBN;
        }
        public function getISBN() {
            return $this->ISBN;
        }

        public function setEditora($editora) {
            $this->editora = $editora;
        }
        public function getEditora() {
            return $this->editora;
        }




        public function setId_LivroA($id_LivroA) {
            $this->id_Livro2 = $id_LivroA;
        }
        public function getId_LivroA() {
            return $this->id_Livro2;
        }

        public function setTituloA($tituloLivroA) {
            $this->tituloLivroA = $tituloLivroA;
        }
        public function getTituloA() {
            return $this->tituloLivroA;
        }

        public function setAutorA($autorLivroA) {
            $this->autorLivroA = $autorLivroA;
        }
        public function getAutorA() {
            return $this->autorLivroA;
        }

        public function setISBNa($ISBNa) {
            $this->ISBNa = $ISBNa;
        }
        public function getISBNa() {
            return $this->ISBNa;
        }

        public function setEditoraA($editoraA) {
            $this->editoraA = $editoraA;
        }
        public function getEditoraA() {
            return $this->editoraA;
        }



        function setId_User($id_usuario){
            $this->id_usuario = $id_usuario;
        }
        function getId_User(){
            return $this->id_usuario;
        }






        
        function inserirLivros() {
            $database = new Conexao(); //nova instancia da conexao
            $db = $database->getConnection(); //tenta conectar
            
            $sql = "INSERT INTO livro (ID_User ,Nome, Autor, ISBN, Editora) VALUES (:ID_User, :Nome, :Autor, :ISBN, :Editora)";
            try {
                $stmt = $db->prepare($sql);
                
                $stmt->bindParam(':ID_User', $this->id_usuario );
                $stmt->bindParam(':Nome', $this->tituloLivro);
                $stmt->bindParam(':Autor', $this->autorLivro);
                $stmt->bindParam(':ISBN', $this->ISBN);
                $stmt->bindParam(':Editora', $this->editora);
                $stmt->execute();
                return true;
            } catch(PDOException $e) { //if(erro==true) {echo $this->mensagem;}
                echo "Erro ao inserir livro: " . $e->getMessage();
                return false;
            }
        }

        
        function listarLivros() {
            $database = new Conexao(); //nova instancia da conexao
            $db = $database->getConnection(); //tenta conectar
    
            $sql = "SELECT * from livro";
    
            try {
                $stmt = $db->query($sql);                                                                                                                                                                                                                                                                                                           
                $rs = $stmt->fetchAll(PDO::FETCH_ASSOC); //rs = result -> resultado  ::::: fetchAll == ecncapsula realizando o processo concatenativo em todos os itens/objetos presentes no ambiente
                return $rs;                          
            } catch(PDOException $e) {
                echo 'Erro ao listar livro(s): ' . $e->getMessage();
                $rs = [];
                return $rs;
            }
        }
     

        function updateLivros(){
            $database = new Conexao(); //nova instância da conexao
            $db = $database->getConnection(); // tenta conectar
            
            $id = $this->getId_Livro();
            $tituloLivro = $this->getTitulo();
            $autorLivro = $this->getAutor();
            $ISBN = $this->getISBN();
            $editora = $this->getEditora();
            
            
           // Preparando a consulta SQL
            $sql = "UPDATE livro SET Nome=:Nome, Autor=:Autor, ISBN=:ISBN, Editora=:Editora WHERE ID_Livro=:ID_Livro";
            
            try {
                // Preparando e executando a consulta
                $stmt = $db->prepare($sql);
                $stmt->bindParam(':ID_Livro', $id);
                $stmt->bindParam(':Nome', $tituloLivro);
                $stmt->bindParam(':Autor', $autorLivro);
                $stmt->bindParam(':ISBN', $ISBN);
                $stmt->bindParam(':Editora', $editora);
                $stmt->execute();
        
                return true;
        
            } catch(PDOException $e) { 
                echo "Erro ao atualizar livro: " . $e->getMessage();
                return false;
            }
        }


        function getLivroById($id) {
            $database = new Conexao(); //nova instância da conexao
            $db = $database->getConnection(); // tenta conectar
    
            $sql = "SELECT * FROM livro WHERE ID_Livro = :id";
            try {
                $stmt = $db->prepare($sql);
                $stmt->bindParam(':id', $id, PDO::PARAM_INT);
                $stmt->execute();
                return $stmt->fetch(PDO::FETCH_ASSOC);
    
            } catch(PDOException $e) {
                echo 'Erro ao buscar livro por ID: ' . $e->getMessage(); 
                return false;
            }   
        }


        function deletarLivros(){
            // Instância da conexão
            $database = new Conexao(); 
            $db = $database->getConnection(); // Obtém a conexão
        
            try{
                // Prepara a consulta SQL para deletar a pessoa com base no ID
                $sql = "DELETE FROM livro WHERE id_Livro = :id_Livro";
                $stmt = $db->prepare($sql);
                
                // Obtém o ID da pessoa
                $id_Livro = $this->getId_Livro2();
                
                // Vincula o parâmetro :id_pessoa ao valor do ID da pessoa
                $stmt->bindParam(':id_Livro', $id_Livro, PDO::PARAM_INT);
                
                // Executa a consulta preparada
                $stmt->execute();
        
                // Retorna true para indicar que a deleção foi realizada com sucesso
                return true;
            
            } catch(PDOException $e){
                // Em caso de erro, imprime a mensagem de erro
                echo "Erro ao deletar pessoa: " . $e->getMessage();
                return false; // Retorna false para indicar falha na deleção
            }
        }

        function getLivrosByIddoUser($ID_User) {
            $database = new Conexao(); //nova instancia da conexao
            $db = $database->getConnection(); //tenta conectar
    
            $sql = "SELECT * FROM livro WHERE ID_User = :ID_User";
    
            try {
                $stmt = $db->prepare($sql);
                $stmt->bindParam(':ID_User', $ID_User, PDO::PARAM_INT);
                $stmt->execute();
                $rs = $stmt->fetchAll(PDO::FETCH_ASSOC);
                return $rs;                          
            } catch(PDOException $e) {
                echo 'Erro ao listar livros: ' . $e->getMessage();
                $rs = [];
                return $rs;
            }
        }
    }
?>