<?php declare(strict_types=1);

include 'vendor/autoload.php';

$client = new Predis\Client([
    'scheme' => 'tcp',
    'host' => 'redis',
    'port' => 6379
]);

echo "Mathiack nº{$client->incr('hits')}!";