//recebe do index.html
// Função para adicionar uma nova tarefa
function addTask() {
    const taskInput = document.getElementById('taskInput');
    const taskText = taskInput.value.trim();
    if (taskText === '') return;

    const taskList = document.getElementById('taskList');
    const li = document.createElement('li');
    li.textContent = taskText;
    li.addEventListener('click', () => {
        li.classList.toggle('completed');
        saveTasks();
    });
    
    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Excluir';
    deleteButton.addEventListener('click', (e) => {
        e.stopPropagation(); // Evita que o evento de clique no li seja acionado
        taskList.removeChild(li);
        saveTasks();
    });
    
    li.appendChild(deleteButton);
    taskList.appendChild(li);
    taskInput.value = '';
    saveTasks();
}

// Função para salvar as tarefas no localStorage
function saveTasks() {
    const tasks = Array.from(document.querySelectorAll('#taskList li')).map(li => {
        return { text: li.firstChild.textContent, completed: li.classList.contains('completed') };
    });
    localStorage.setItem('tasks', JSON.stringify(tasks));
}

// Função para carregar as tarefas do localStorage
function loadTasks() {
    const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
    tasks.forEach(task => {
        const taskList = document.getElementById('taskList');
        const li = document.createElement('li');
        li.textContent = task.text;
        if (task.completed) li.classList.add('completed');

        const deleteButton = document.createElement('button');
        deleteButton.className = 'delete-button'; //permite css
        deleteButton.textContent = 'Excluir';
        deleteButton.addEventListener('click', (e) => {
            e.stopPropagation(); // Evita que o evento de clique no li seja acionado
            taskList.removeChild(li);
            saveTasks();
        });

        li.appendChild(deleteButton);
        taskList.appendChild(li);
    });
}

// Adiciona o evento de clique ao botão de adicionar tarefa
document.getElementById('addTaskButton').addEventListener('click', addTask);

// Carrega as tarefas ao iniciar a página
loadTasks();