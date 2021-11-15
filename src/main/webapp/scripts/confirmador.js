
function confirmaExclusao(id) {
	let resposta = confirm("Confirma a exclusão deste produto?")
	if(resposta === true){
	window.location.href= "delete?id=" + id
	}
}