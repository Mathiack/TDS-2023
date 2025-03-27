let n = prompt("N: ");

if(!isNaN(n)) {
    imprimirTabuada(n);
} else {
    alert("Insira um número válido");
}


function imprimirTabuada(n) {
    for(i=0; i<=10; i++) {
        let res = n * i;
        let paridade;

        if (res % 2 === 0) {
            paridade = "Par";
        } else {
            paridade = "Ímpar";
        }

        console.log(n + " x " + i + " = " + res + ", é " + paridade);
    }
}
