<?php
session_start();

if (isset($_SESSION['usuario'])) {
    header('Location: diario.php');
    exit;
}

header('Content-Type: application/json');
$input = json_decode(file_get_contents('php://input'), true);
$usuario = $input['usuario'] ?? '';
$senha = $input['senha'] ?? '';

$dados = json_decode(file_get_contents('usuarios.json'), true);

foreach ($dados['usuarios'] as $u) {
    if ($u['usuario'] === $usuario && password_verify($senha, $u['senha'])) {
        $_SESSION['usuario'] = $usuario;
        echo json_encode(['status' => 'ok']);
        exit;
    }
}

http_response_code(401);
echo json_encode(['erro' => 'Usuário ou senha inválidos']);
