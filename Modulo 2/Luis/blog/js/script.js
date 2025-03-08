// script.js

const themeToggleButton = document.getElementById('theme-toggle');
const body = document.body;

// Verifica se o modo escuro foi ativado anteriormente
if (localStorage.getItem('dark-mode') === 'enabled') {
    body.classList.add('dark-mode');
    themeToggleButton.textContent = '🌞'; // Mudar ícone para sol no modo escuro
} else {
    body.classList.remove('dark-mode');
    themeToggleButton.textContent = '🌙'; // Mudar ícone para lua no modo claro
}

// Alterna entre modo claro e escuro
themeToggleButton.addEventListener('click', () => {
    if (body.classList.contains('dark-mode')) {
        body.classList.remove('dark-mode');
        themeToggleButton.textContent = '🌙'; // Exibe lua no modo claro
        localStorage.setItem('dark-mode', 'disabled'); // Salva no localStorage
    } else {
        body.classList.add('dark-mode');
        themeToggleButton.textContent = '🌞'; // Exibe sol no modo escuro
        localStorage.setItem('dark-mode', 'enabled'); // Salva no localStorage
    }
});
