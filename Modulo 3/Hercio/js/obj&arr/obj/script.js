// script.js

const produto = {
    id: 1,
    nome: "Camiseta Do Verstappen",
    preco: 1,
    emEstoque: true,
    mostrarDetalhes: function() {
        console.log(`Produto: ${this.nome}, Preço ${this.preco}`);
    }
};

console.log(produto.nome);
console.log(produto["preco"]);
produto.mostrarDetalhes();

//add nova propriedade
produto.categoria = "Roupas de Luxo";

//modificar uma propriedade existente
produto.preco = 1.1;

//remover uma propriedade existente
delete produto.emEstoque;