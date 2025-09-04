<?php declare(strict_types=1);

include 'vendor/autoload.php';

$client = new Predis\Client([
    'scheme' => 'tcp',
    'host' => getenv('REDIS_HOST'),
    'port' => getenv('REDIS_PORT'),
]);

echo "Mathiack nº{$client->incr('hits')}!";