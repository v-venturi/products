
function validar() {
	let descricao = formProduto.descricao.value
	let preco = formProduto.preco.value
	let estoque = formProduto.estoque.value

	if (descricao.length < 3) {
		alert('Preencha o campo Descrição')
		formProduto.descricao.focus()
		return false
	} else if (preco === "") {
		alert('Preencha o campo Preço')
		formProduto.preco.focus()
		return false
	} else if (estoque === "") {
		alert('Preencha o campo Estoque')
		formProduto.estoque.focus()
		return false
	} else {
		document.forms["formProduto"].submit()
		
	}
}
