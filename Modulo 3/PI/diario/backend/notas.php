<?php
// backend/notas.php
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST, PUT, DELETE');
header('Access-Control-Allow-Headers: Content-Type');

$notasFile = 'notas.json';

function carregarNotas() {
    global $notasFile;
    return file_exists($notasFile) ? json_decode(file_get_contents($notasFile), true) : [];
}

function salvarNotas($notas) {
    global $notasFile;
    file_put_contents($notasFile, json_encode($notas, JSON_PRETTY_PRINT));
}

$method = $_SERVER['REQUEST_METHOD'];
$data = json_decode(file_get_contents('php://input'), true);

if ($method === 'GET') {
    echo json_encode(carregarNotas());
} elseif ($method === 'POST') {
    $notas = carregarNotas();
    $novaNota = [
        'id' => count($notas) ? end($notas)['id'] + 1 : 1,
        'titulo' => $data['titulo'],
        'conteudo' => $data['conteudo'],
        'data' => date('Y-m-d')
    ];
    $notas[] = $novaNota;
    salvarNotas($notas);
    echo json_encode($novaNota);
} elseif ($method === 'PUT') {
    $notas = carregarNotas();
    foreach ($notas as &$nota) {
        if ($nota['id'] == $data['id']) {
            $nota['titulo'] = $data['titulo'];
            $nota['conteudo'] = $data['conteudo'];
            salvarNotas($notas);
            echo json_encode($nota);
            exit;
        }
    }
    http_response_code(404);
    echo json_encode(['erro' => 'Nota não encontrada']);
} elseif ($method === 'DELETE') {
    $notas = carregarNotas();
    $notas = array_filter($notas, fn($nota) => $nota['id'] != $data['id']);
    salvarNotas(array_values($notas));
    http_response_code(204);
} else {
    http_response_code(405);
    echo json_encode(['erro' => 'Método não permitido']);
}
?>
