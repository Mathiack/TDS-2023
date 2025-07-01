<?php

include 'vendor/autoload.php';

$dispatcher = FastRoute\simpleDispatcher(function(FastRoute\RouteCollector $r) {
    $r->addRoute('GET', '/', function($var = null): array {
        return [
            'status_code' => 200,
            'data' => ['INDEX'],
        ];
    });
    $r->addRoute('GET', '/v0/status', function($var = null): array {
        return [
            'status_code' => 200,
            'data' => ['status' => 'está funcionando'],
        ];
    });
});

// Fetch method and URI from somewhere
$httpMethod = $_SERVER['REQUEST_METHOD'];
$uri = $_SERVER['REQUEST_URI'];
// $uri = $_SERVER['REDIRECT_QUERY_STRING']; // printa que está funcionando

// Strip query string (?foo=bar) and decode URI
if (false !== $pos = strpos($uri, '?')) {
    $uri = substr($uri, 0, $pos);
}
$uri = rawurldecode($uri);

$routeInfo = $dispatcher->dispatch($httpMethod, $uri);

$response = [
    'status_code' => 501,
];

switch ($routeInfo[0]) {
    case FastRoute\Dispatcher::NOT_FOUND:
        $response = [
            'status_code' => 404,
            'message' => 'not found',
            'nome' => 'Mathiack',
            'email' => 'mathiack@email.com',
            'idade' => 16,
            'altura' => 1.85,
            '!false' => true,
            'filiacao' => [
                'pai' => 'pai',
                'mae' => 'mae',
                'namorada' => 'me falta',
                'filho_ou_filha' => 'n quero',
                'cachorro' => 'tenho',
            ],
            'langs' => [
                'c', 'js', 'java', 'html', 'css', 'python', 'ruby', 'c#'
            ]
        ];
        break;
    case FastRoute\Dispatcher::METHOD_NOT_ALLOWED:
        $allowedMethods = $routeInfo[1];
        $response = [
            'status_code' => 405,
            'message' => 'method not allowed',
        ];
        break;
    case FastRoute\Dispatcher::FOUND:
        $handler = $routeInfo[1];
        $vars = $routeInfo[2];
        $response = array_merge($response, $handler($vars));
        break;
}

http_response_code($response['status_code']);
header('Content-type: application/json');
echo json_encode($response, JSON_PRETTY_PRINT);
