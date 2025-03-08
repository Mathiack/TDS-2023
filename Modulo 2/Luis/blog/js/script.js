// script.js

const themeToggleButton = document.getElementById("theme-toggle");

themeToggleButton.addEventListener("click", () => {
    document.body.classList.toggle("dark-mode");

    // Alterar ícone do botão
    if (document.body.classList.contains("dark-mode")) {
        themeToggleButton.textContent = "🌞"; // Modo Claro
    } else {
        themeToggleButton.textContent = "🌙"; // Modo Escuro
    }
});
