<?php
include 'auth.php';
header('Content-Type: application/json');
$usuarioLogado = $_SESSION['usuario'];
$dados = json_decode(file_get_contents('usuarios.json'), true);

$input = json_decode(file_get_contents('php://input'), true);
$titulo = $input['titulo'] ?? '';
$conteudo = $input['conteudo'] ?? '';
$id = $input['id'] ?? '';
$metodo = $_SERVER['REQUEST_METHOD'];

foreach ($dados['usuarios'] as &$user) {
    if ($user['usuario'] === $usuarioLogado) {
        if ($metodo === 'POST') {
            if ($id === '') {
                $user['notas'][] = [ 'titulo' => $titulo, 'conteudo' => $conteudo ];
            } else {
                $user['notas'][(int)$id] = [ 'titulo' => $titulo, 'conteudo' => $conteudo ];
            }
        } elseif ($metodo === 'DELETE' && $id !== '') {
            array_splice($user['notas'], (int)$id, 1);
        }
        break;
    }
}

file_put_contents('usuarios.json', json_encode($dados, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));
echo json_encode(['status' => 'ok']);
