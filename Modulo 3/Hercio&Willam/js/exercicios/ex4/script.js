class Prod {
    constructor(id, nome, preco, categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }
}

const produtos = [
    new Prod(1, "Capacete Verstappen", 1500, "Acessórios"),
    new Prod(2, "Miniatura RB20 Verstappen", 800, "Colecionáveis"),
    new Prod(3, "Camisa Red Bull Racing Verstappen", 300, "Vestuário"),
    new Prod(4, "Boné Max Verstappen", 200, "Acessórios"),
    new Prod(5, "Jaqueta Red Bull Verstappen", 600, "Vestuário"),
    new Prod(6, "Chaveiro Red Bull Verstappen", 50, "Acessórios"),
    new Prod(7, "Jaqueta Edição Especial Verstappen", 750, "Vestuário"),
    new Prod(8, "Poster Autografado Verstappen", 1200, "Colecionáveis"),
    new Prod(9, "Mochila Red Bull Racing Verstappen", 350, "Acessórios"),
    new Prod(10, "Carteira Red Bull Verstappen", 180, "Acessórios"),
    new Prod(11, "Relógio Oficial Red Bull Racing", 2500, "Colecionáveis"),
    new Prod(12, "Tênis Red Bull Racing Verstappen", 900, "Vestuário"),
    new Prod(13, "Luva de Kart Verstappen", 400, "Acessórios"),
    new Prod(14, "Caneca Red Bull Verstappen", 90, "Colecionáveis"),
    new Prod(15, "Adesivo Red Bull Racing Verstappen", 30, "Acessórios")
];

// fazendo mais alguns por que quis usar push
const produtosAdicionais = [
    new Prod(16, "Óculos de Sol Red Bull Racing", 650, "Acessórios"),
    new Prod(17, "Jaqueta Softshell Verstappen", 850, "Vestuário"),
    new Prod(18, "Luva Oficial de Piloto Verstappen", 2000, "Colecionáveis"),
    new Prod(19, "Carrinho Hot Wheels RB20 Verstappen", 150, "Colecionáveis"),
    new Prod(20, "Camiseta Casual Max Verstappen", 250, "Vestuário"),
    new Prod(21, "Mousepad Red Bull Racing", 100, "Acessórios"),
    new Prod(22, "Bandeira Oficial Verstappen", 180, "Colecionáveis"),
    new Prod(23, "Bolsa Esportiva Red Bull Racing", 500, "Acessórios"),
    new Prod(24, "Blusão com Capuz Verstappen", 700, "Vestuário"),
    new Prod(25, "Copo Térmico Red Bull Racing", 130, "Colecionáveis"),
    new Prod(26, "Chaveiro Mini Capacete Verstappen", 75, "Acessórios"),
    new Prod(27, "Carteira Oficial Red Bull Verstappen", 250, "Acessórios"),
    new Prod(28, "Tênis Edição Limitada Verstappen", 1200, "Vestuário"),
    new Prod(29, "Jaqueta Corta-Vento Red Bull Racing", 950, "Vestuário"),
    new Prod(30, "Moletom Max Verstappen 33", 800, "Vestuário")
];

produtos.push(...produtosAdicionais);

let resposta = prompt("Filtrar por (nome, preco, categoria)?").toLowerCase();

if (resposta === "nome") {
    let listadoNome = [...produtos].sort((a, b) => a.nome.localeCompare(b.nome));
    console.log("Ordem alfabética:", listadoNome);

} else if (resposta === "preco") {
    let resposta2 = prompt("Maior ou menor?").toLowerCase();
    let listadoPreco;
    
    if (resposta2 === "maior") {
        listadoPreco = [...produtos].sort((a, b) => b.preco - a.preco);
    } else {
        listadoPreco = [...produtos].sort((a, b) => a.preco - b.preco);
    }
    
    console.log("Ordenado por preço:", listadoPreco);

} else if (resposta === "categoria") {
    let listadoCategoria = [...produtos].sort((a, b) => a.categoria.localeCompare(b.categoria));
    console.log("Ordenado por categoria:", listadoCategoria);

} else {
    console.log("Opção inválida!");
}
