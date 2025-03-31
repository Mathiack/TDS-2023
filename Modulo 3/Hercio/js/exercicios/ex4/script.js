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
    new Prod(5, "Jaqueta Red Bull Verstappen", 600, "Vestuário")
];

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
