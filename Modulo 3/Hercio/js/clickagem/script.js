const botao = document.getElementById("botao");

// identation's by Monari14 Copyright 2025
botao.addEventListener(
    "click", ()=> 
    {
        /*
        const nome = document.getElementById("nome").value;
        const email = document.getElementById("email").value;
        alert("Botão clikenado");
        */
        
        if (nomeC.trim() === "" || email.trim() === "") {
            alert("Preencha todos os campos");
            return;
        }
        const nomeC = document.getElementById("nomeC");
        const emailC = document.getElementById("emailC");
        
        nomeC.textContent=`${nome}`;
        emailC.textContent=`${email}`;
    });

/* const campoTexto = document.getElementById("nome");
campoTexto.addEventListener("input", (event)=> { 
    console.log("Valor atual: ", event.target.value);
}); */