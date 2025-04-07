// arrays

const numeros = [10, 20, 30, 40, 50];
console.log(numeros[0]); //10
console.log(numeros[4]); // 50

numeros.forEach(numero => {
    console.log("Número: ", numero);
})

//push: add elemento ao final de um array
let frutas = ["massa", "banana", "chop", "kawasaki"];
frutas.push("Laranja(cor ou fruta?)");
console.log("Array após pushada: ", frutas);

//shift: remove o primeiro elemento do array
let frutaRemovida = frutas.shift();
console.log("Fruta removida: ", frutaRemovida);
console.log("Array após o shift: ", frutas);

//remove o último elemento do array
let ultimaFruta = frutas.pop();
console.log("Fruta removida: ", ultimaFruta);
console.log("Array após pop: ", frutas);

//unshift: add 1 elemento ao início do array
frutas.unshift("morangilho");
console.log("Array após unshift", frutas);

//splice: remover ou add elementos em qualquer posição
//Ex.: remover 1 elemento a partir do índice 1
let removidos = frutas.splice(1,1);
console.log("Após o splice (rm 1 elemento no índice 1): ", frutas);
console.log("Elemento removido: ", removidos);

//Ex.2: add elementos no índice 1 sem remover nenhum elemento
frutas.splice(1,0, "baixaqui", "vinho - fermentação");
console.log("Após splice, add baixaqui e vinho - fermentação no índice 1: ", frutas);

//sort: ordenar em ordem alfabética
frutas.sort();
console.log("Array após sort: ", frutas);

//map: cria um array com o resultado da aplicação de uma função em cada elemento
const numerosDobrados = numeros.map(numero => numero*2);
console.log(numerosDobrados);

//filter: criar um array contendo apenas os elementos que atendem uma condição
const numeroAleatorios = [1, 5, 7, 19, 22];
const numerosPares = numeroAleatorios.filter(numero => numero %2===0);
console.log("Pares: ",numerosPares);

function maiorQue(valor) {
    return valor>10;
}

const maiores = numeroAleatorios.filter(maiorQue);
console.log("Maiores que 10: ", maiores);