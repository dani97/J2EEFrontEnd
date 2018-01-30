/**
 * 
 */

var recordContainer = document.getElementsByClassName('list-container-in')[0];
recordContainer.addEventListener('click',function (event) {
	setRecord(event);
});

function setRecord(event) {
	var element = event.srcElement;
	record = document.getElementById('record').value = element.dataset.record;
}