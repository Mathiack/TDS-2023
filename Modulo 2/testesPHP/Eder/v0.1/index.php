<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erros</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php 

        require 'vendor/autoload.php';

        $dispatcher = FastRoute\simpleDispatcher(function(FastRoute\RouteCollector $r) {
            $r->addRoute('GET', '/v0/fodase', 'get_all_users_handler'); //rota

            $r->addRoute('GET', '/v0/fodasi', 'get_user_handler'); //rota

            $r->addRoute('GET', '/articles/{id:\d+}[/{title}]', 'get_article_handler'); //rota
        });

        // Fetch method and URI from somewhere
        $httpMethod = $_SERVER['REQUEST_METHOD'];
        $uri = $_SERVER['REQUEST_URI'];

        // Strip query string (?foo=bar) and decode URI
        if (false !== $pos = strpos($uri, '?')) {
            $uri = substr($uri, 0, $pos);
        }
        $uri = rawurldecode($uri);
    ?>
<div class="erros">
    <?php
        $routeInfo = $dispatcher->dispatch($httpMethod, $uri);
        switch ($routeInfo[0]) {
            case FastRoute\Dispatcher::NOT_FOUND:
                ?>
                <div id="404">
                        <?php
                            echo 'NOT_FOUND'; //caso nao encontre, printa erro 404
                        ?>
                </div>
                <?php
                break;
            case FastRoute\Dispatcher::METHOD_NOT_ALLOWED:
                $allowedMethods = $routeInfo[1];
                ?>
                <div id="405">
                    <?php
                    echo 'METHOD_NOT_ALLOWED'; //caso nao encontre, printa erro 405
                    ?>
                </div>
                <?php
                break;
            case FastRoute\Dispatcher::FOUND:
                $handler = $routeInfo[1];
                $vars = $routeInfo[2];
                ?>
                <div id="found">
                    <?php
                    echo 'FOUND'; //caso nao encontre, printa erro 404
                    ?>
                </div>
                <?php
                break;
        }
    ?>
</div>
</body>
</html>
