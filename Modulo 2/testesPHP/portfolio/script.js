document.getElementById("theme-toggle").addEventListener("click", function() {
    document.body.classList.toggle("dark-mode");
    const mode = document.body.classList.contains("dark-mode") ? "Claro" : "Escuro";
    this.textContent = `Modo ${mode}`;
  });
  