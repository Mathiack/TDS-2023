// Menu Toggle (Responsivo)
const menuToggle = document.querySelector('.menu-toggle');
const menu = document.querySelector('.menu');

// Validação de Formulário de Contato
document.getElementById('contact-form').addEventListener('submit', function(event) {
    const name = this.name.value;
    const email = this.email.value;
    const message = this.message.value;

    if (!name || !email || !message) {
        event.preventDefault();
        alert('Por favor, preencha todos os campos.');
    }
});

// JavaScript para controlar a rolagem suave manualmente (opcional)
document.querySelectorAll('.menu a').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();

        const targetId = this.getAttribute('href').substring(1);
        const targetElement = document.getElementById(targetId);

        // Rola suavemente até a seção
        window.scrollTo({
            top: targetElement.offsetTop - 50, // Ajuste o valor de 50 conforme necessário
            behavior: 'smooth'
        });
    });
});
