document.querySelectorAll('.excluir').forEach(function(button) {
    button.addEventListener('click', function() {
        if (confirm('Confirma a exclusao?')) {
            const row = this.closest('tr');
            const produtoId = this.dataset.produtoId;

            fetch(`/produto/${produtoId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(response => {
                if (response.ok) {
                    console.log('Produto excluido com sucesso.');
                    row.remove();
                } else {
                    console.error('Erro ao excluir produto.');
                    alert('Erro ao excluir produto');
                }
            })
            .catch(error => {
                console.error('Erro de rede:', error);
                alert('Erro de rede:' + error);
            });
        }
    });
});
