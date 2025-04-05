<?php
session_start();
header('Content-Type: application/json');

$input = json_decode(file_get_contents('php://input'), true);
$usuario = $input['usuario'] ?? '';
$senha = $input['senha'] ?? '';

if (!$usuario || !$senha) {
    http_response_code(400);
    echo json_encode(['erro' => 'Campos obrigatórios']);
    exit;
}

$dados = json_decode(file_get_contents('usuarios.json'), true);

foreach ($dados['usuarios'] as $u) {
    if ($u['usuario'] === $usuario) {
        http_response_code(409);
        echo json_encode(['erro' => 'Usuário já existe']);
        exit;
    }
}

$dados['usuarios'][] = [
    'usuario' => $usuario,
    'senha' => password_hash($senha, PASSWORD_DEFAULT),
    'notas' => []
];

file_put_contents('usuarios.json', json_encode($dados, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));

$_SESSION['usuario'] = $usuario;
echo json_encode(['status' => 'ok']);