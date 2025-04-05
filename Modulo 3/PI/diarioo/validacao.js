window.addEventListener('load', () => {
  fetch('auth.php')
    .then(res => {
      if (!res.ok) throw new Error('Sessão expirada');
    })
    .catch(() => {
      alert('Sessão expirada. Faça login novamente.');
      window.location.href = 'login.php';
    });
});