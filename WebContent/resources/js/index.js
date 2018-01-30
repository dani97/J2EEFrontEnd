/**
 * 
 */

var button = document.getElementById('record-button');
button.addEventListener('click',showForm);
function showForm() {
	var form = document.getElementById("record-form");
	form.classList.add('slider');
	button.parentNode.classList.add('hide');
}
var closer = document.getElementById('closer');
closer.addEventListener('click',close);

function close() {
	var form = document.getElementById("record-form");
	form.classList.remove('slider');
	button.parentNode.classList.remove('hide');
}