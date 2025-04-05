<?php
include 'auth.php';
$usuarioLogado = $_SESSION['usuario'];
$dados = json_decode(file_get_contents('usuarios.json'), true);

// Buscar notas do usuário logado
$notas = [];
foreach ($dados['usuarios'] as $user) {
    if ($user['usuario'] === $usuarioLogado) {
        $notas = $user['notas'] ?? [];
        break;
    }
}
?>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Diário</title>
    <link rel="stylesheet" href="styles/styleDiario.css">
</head>
<body>
<div class="navbar">
    Diário Pessoal
    <a href="logout.php" style="float:right; color:white; margin-right:20px; text-decoration:none;">Sair</a>
</div>
<div class="main-content">
    <div class="sidebar">
        <h2>Menu</h2>
        <button class="directBtn"><a href="#">Minhas Notas</a></button>
        <button class="directBtn"><a href="#">Nova Nota</a></button>
    </div>
    <div class="container">
        <div class="diario">
            <h1>Minhas Notas</h1>
            <form id="nota-form">
                <input type="hidden" id="nota-id">
                <input type="text" id="titulo" placeholder="Título" required>
                <textarea id="conteudo" placeholder="Escreva sua nota..." required></textarea>
                <button type="submit">Salvar Nota</button>
            </form>
            <ul id="lista-notas">
                <?php foreach ($notas as $index => $nota): ?>
                    <li data-id="<?php echo $index; ?>">
                        <strong><?php echo htmlspecialchars($nota['titulo']); ?></strong><br>
                        <span><?php echo nl2br(htmlspecialchars($nota['conteudo'])); ?></span><br>
                        <button class="editar">Editar</button>
                        <button class="excluir">Excluir</button>
                    </li>
                <?php endforeach; ?>
            </ul>
        </div>
    </div>
</div>
<script>
    const form = document.getElementById('nota-form');
    const titulo = document.getElementById('titulo');
    const conteudo = document.getElementById('conteudo');
    const notaId = document.getElementById('nota-id');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        const res = await fetch('salvar_nota.php', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                id: notaId.value,
                titulo: titulo.value,
                conteudo: conteudo.value
            })
        });
        location.reload();
    });

    document.querySelectorAll('.editar').forEach(btn => {
        btn.addEventListener('click', e => {
            const li = e.target.closest('li');
            notaId.value = li.dataset.id;
            titulo.value = li.querySelector('strong').innerText;
            conteudo.value = li.querySelector('span').innerText;
        });
    });

    document.querySelectorAll('.excluir').forEach(btn => {
        btn.addEventListener('click', async e => {
            const li = e.target.closest('li');
            await fetch('salvar_nota.php', {
                method: 'DELETE',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id: li.dataset.id })
            });
            location.reload();
        });
    });
</script>
</body>
</html>
