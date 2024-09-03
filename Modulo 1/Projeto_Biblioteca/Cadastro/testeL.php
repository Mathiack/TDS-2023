<?php
    // Acessa
    session_start();
    include_once "../conexao.php";

    // print_r($_REQUEST);
    
    if(isset($_POST['submit']) && !empty($_POST['email']) && !empty($_POST['senha']))
    {
        $database = new Conexao(); 
        $db = $database->getConnection();

        $email = $_POST['email'];
        $senha = $_POST['senha'];

        //print_r('Email: ' . $email);
        //print_r('<br>');
        //print_r('Senha: ' . $senha);
        
        $sql = "SELECT * FROM usuario WHERE email = :email AND senha = :senha";
        $stmt = $db->prepare($sql);
        $stmt->execute(['email' => $email, 'senha' => $senha]);

        //print_r($sql);
        //print_r($stmt);
    
    if($stmt->rowCount() < 1)
    {
        unset($_SESSION['email']);
        unset($_SESSION['senha']);
        header('Location: login.php');
    }
    else
    {
        //se acessar, vem aqui
        $rs = $stmt->fetch(PDO::FETCH_ASSOC);
        $_SESSION['ID_User'] = $rs['ID_User'];
        $_SESSION['email'] = $email;
        $_SESSION['senha'] = $senha;
        header('Location: ../Estante/index.php');    //redirecionar para a biblioteca pagina inicial
        }
    }
    else
    {
        // Não acessa
        header('Location: login.php');
    }
?>