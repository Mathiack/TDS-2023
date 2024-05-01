<?php
include "Classes/Cliente.php";
include "Classes/Endereco.php";
include "Classes/Faturamento.php";
include "Classes/ItemDoPedido.php";
include "Classes/Pedido.php";
include "Classes/Batatinha.php";
include "Classes/Cerveja.php";
include "Classes/Pizza.php";
include "Classes/Refri.php";
//informa coisas basicas do cliente
$cliente = new Cliente();
$nome = $_POST['nome'];
$cliente->setNome($nome);
$contato = $_POST['contato']
$cliente->setContato($contato);

$endereco = new Endereco();
$rua = $_POST['rua'];
$endereco->setRua($rua);
$bairro = $_POST['bairro'];
$endereco->setBairro($bairro);
$cidade = $_POST['cidade'];
$endereco->setCidade($cidade);

$cliente->setEndereco($endereco);

$pedido = new Pedido();
$pedido->setCliente($cliente);

$pizza = new Pizza();
$sabor = $_POST['sabor'];
$pizza->setSabor($sabor);
$tamanho = $_POST['tamanho'];
$pizza->setTamanho($tamanho);
$pizza->setValor($valor);
$pedido->addItemDoPedido($pizza);

$pizza = new Pizza();
$pizza->setSabor("Flango");
$pizza->setTamanho("Média");
$pizza->setBorda("Catupiry");
$pizza->setValor(60.0);
$pedido->addItemDoPedido($pizza);

$refri = new Refri();
$refri->setMarca("Fanta");
$refri->setSabor("Laranja");
$refri->setTipo("2 litros");
$refri->setValor(10.0);
$pedido->addItemDoPedido($refri);

$cerveja = new Cerveja();
$cerveja->setMarca("Heinekein");
$cerveja->setTipo("Garrafa");
$cerveja->setValor(5.0);
$pedido->addItemDoPedido($cerveja);

$batatinha = new Batatinha();
$batatinha->setTamanho("Porção Pequena");
$batatinha->setValor(10.0);
$pedido->addItemDoPedido($batatinha);

/*echo "__________________________________________________________" . "<br>";
echo "Nome: " . $pedido->getCliente()->getNome() . "<br>";
echo "Contato: " . $pedido->getCliente()->getContato() . "<br>";
echo "__________________________________________________________" . "<br>";
echo "Endereço: <br>";
echo "Rua: " . $pedido->getEndereco()->getRua() . "<br>";
echo "Bairro: " . $pedido->getEndereco()->getBairro() . "<br>";
echo "Cidade: " . $pedido->getEndereco()->getCidade() . "<br>";*/

?>