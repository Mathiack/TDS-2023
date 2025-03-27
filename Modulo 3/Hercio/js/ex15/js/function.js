function verificarPariedade(num) {
    let msg;
    if (num % 2 === 0) {
        msg = "Par.";
    } else {
        msg = "Ímpar.";
    }

    return msg;
}

console.log(verificarPariedade(7));