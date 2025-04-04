document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("nota-form");
    const listaNotas = document.getElementById("lista-notas");
    const tituloInput = document.getElementById("titulo");
    const conteudoInput = document.getElementById("conteudo");
    const notaIdInput = document.getElementById("nota-id");

    function carregarNotas() {
        fetch("../backend/notas.php")
            .then(res => res.json())
            .then(notas => {
                listaNotas.innerHTML = "";
                notas.forEach(nota => {
                    const li = document.createElement("li");
                    li.innerHTML = `
                        <strong>${nota.titulo}</strong> - ${nota.data}<br>
                        <p>${nota.conteudo}</p>
                        <button onclick="editarNota(${nota.id}, '${nota.titulo}', '${nota.conteudo}')">Editar</button>
                        <button onclick="deletarNota(${nota.id})">Excluir</button>
                    `;
                    listaNotas.appendChild(li);
                });
            });
    }

    form.addEventListener("submit", (e) => {
        e.preventDefault();
        const id = notaIdInput.value;
        const nota = {
            titulo: tituloInput.value,
            conteudo: conteudoInput.value
        };
        fetch("../backend/notas.php", {
            method: id ? "PUT" : "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(id ? { ...nota, id: Number(id) } : nota)
        }).then(() => {
            form.reset();
            carregarNotas();
        });
    });

    window.editarNota = (id, titulo, conteudo) => {
        notaIdInput.value = id;
        tituloInput.value = titulo;
        conteudoInput.value = conteudo;
    };

    window.deletarNota = (id) => {
        fetch("../backend/notas.php", {
            method: "DELETE",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ id })
        }).then(() => carregarNotas());
    };

    carregarNotas();
});
