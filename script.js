document.addEventListener('DOMContentLoaded', () => {
    const output = document.getElementById('output');
    const input = document.getElementById('input');
    const submit = document.getElementById('submit');

    function appendMessage(message) {
        output.innerHTML += `<p>${message}</p>`;
        output.scrollTop = output.scrollHeight;
    }

    function handleCommand() {
        const command = input.value.trim();
        if (command) {
            // Envia o comando ao backend
            fetch('http://localhost:8080/command', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ command: command })
            })
            .then(response => response.json())
            .then(data => {
                appendMessage(`Você: ${command}`);
                appendMessage(`Jogo: ${data.response}`);
                input.value = '';
            })
            .catch(error => {
                appendMessage(`Erro ao se comunicar com o servidor: ${error}`);
            });
        }
    }

    submit.addEventListener('click', handleCommand);
    input.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            handleCommand();
        }
    });
});
