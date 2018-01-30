/**
 * 
 */

var recordContainer = document.getElementsByClassName('list-container')[0];
recordContainer.addEventListener('click',function (event) {
	createChart(event);
});
var chartId=0;
function reCreate() {
	var content = document.getElementsByClassName('graphical-report__layout')[chartId++];
	content.classList.add('hide');
}  

function createChart(event) {
	var element = event.srcElement;
	var record = element.dataset.record;
	try {
		reCreate();
		if(record==="main"){
			createMainChart();
		} else {
		chart(record);
		}
		
	}catch(e){
		chartId--;
	}
}

function chart(record) {
	var url="http://localhost:8080/MusicJ2EEBackEnd/recordName";
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var chartData = JSON.parse(this.responseText);
			var mychart = {};
			mychart['data'] = chartData;
			mychart['x'] = 'raterName';
			mychart['y'] = 'rating';
			mychart['type'] = 'bar';
			mychart['color'] = 'raterName';
			mychart['settings'] = {
					fitModel: 'entire-view'
			  };
			mychart["plugins"] = [
		        tauCharts.api.plugins.get('tooltip')({
		            fields: ['raterName','rating','recordName'],
		            formatters: {
		            	raterName : {
		            		label : "Rater"
		            	},
		            	recordName : {
		            		label : "Record"
		            	}
		            }
		        }),
		        tauCharts.api.plugins.get('legend')()
		    ];
			
			var charter = new tauCharts.Chart(mychart);
			charter.renderTo("#my-chart");
		}else if(this.status <200&this.status>300){
			alert('couldn"t fetch content; check your connection');
		}
	};
	xhttp.open("POST",url, true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("recordName="+record);
	
}

function createMainChart() {
	
	var url = "http://localhost:8080/MusicJ2EEBackEnd/GetAllRating";
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		
		if (this.readyState == 4 && this.status == 200) {
			var chartData = JSON.parse(this.responseText);
			var mychart = {};
			mychart['data'] = chartData;
			mychart['x'] = 'recordName';
			mychart['y'] = 'rating';
			mychart['type'] = 'scatterplot';
			mychart['color'] = 'raterName';
			mychart['size'] = 'rating';
			mychart['settings'] = {
					fitModel: 'entire-view'
			  };
			mychart["plugins"] = [
		        tauCharts.api.plugins.get('tooltip')({
		            fields: ['raterName','rating','recordName'],
		            formatters: {
		            	raterName : {
		            		label : "Rater"
		            	},
		            	recordName : {
		            		label : "Record"
		            	}
		            }
		        }),
		        tauCharts.api.plugins.get('legend')({
		        	fields: 'raterName',
		        	formatters: {
		        		raterName : {
		            		label : "Rater"
		            	}
		        	}
		        })
		    ];
			var charter = new tauCharts.Chart(mychart);
			charter.renderTo("#my-chart");
		}else if(this.status <200&this.status>300){
			alert('couldn"t fetch content; check your connection');
		}
	};
	xhttp.open("POST",url, true);
	xhttp.send();
}
createMainChart();
