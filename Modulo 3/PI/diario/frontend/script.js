document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("nota-form");
    const tituloInput = document.getElementById("titulo");
    const conteudoInput = document.getElementById("conteudo");
    const listaNotas = document.getElementById("lista-notas");
    const notaIdInput = document.getElementById("nota-id");

    let notas = [];

    form.addEventListener("submit", (e) => {
        e.preventDefault();

        const titulo = tituloInput.value.trim();
        const conteudo = conteudoInput.value.trim();

        if (titulo && conteudo) {
            const notaExistenteIndex = notas.findIndex(n => n.id === notaIdInput.value);

            if (notaExistenteIndex > -1) {
                notas[notaExistenteIndex] = {
                    id: notaIdInput.value,
                    titulo,
                    conteudo
                };
            } else {
                notas.push({
                    id: Date.now().toString(),
                    titulo,
                    conteudo
                });
            }

            renderNotas();
            form.reset();
            notaIdInput.value = '';
        }
    });

    function renderNotas() {
        listaNotas.innerHTML = "";

        notas.forEach(nota => {
            const li = document.createElement("li");
            li.innerHTML = `
                <strong>${nota.titulo}</strong><br>
                <p>${nota.conteudo}</p>
                <button onclick="editarNota('${nota.id}')">Editar</button>
                <button onclick="excluirNota('${nota.id}')">Excluir</button>
            `;
            listaNotas.appendChild(li);
        });
    }

    window.editarNota = function(id) {
        const nota = notas.find(n => n.id === id);
        if (nota) {
            tituloInput.value = nota.titulo;
            conteudoInput.value = nota.conteudo;
            notaIdInput.value = nota.id;
        }
    };

    window.excluirNota = function(id) {
        notas = notas.filter(n => n.id !== id);
        renderNotas();
    };
});
