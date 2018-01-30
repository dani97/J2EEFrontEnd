/**
 * 
 */
var profileContainer = document.getElementsByClassName('list-container-in')[0];
var spinner;
profileContainer.addEventListener('click',function (event) {
	setProfile(event);
});
var profile;
var record;
function setProfile(event) {
	var element = event.srcElement;
	profile = document.getElementById('profile').value = element.dataset.profile;
	stateReady();
}

var recordContainer = document.getElementsByClassName('list-container-in')[1];
recordContainer.addEventListener('click',function (event) {
	setRecord(event);
});

function setRecord(event) {
	var element = event.srcElement;
	record = document.getElementById('record').value = element.dataset.record;
	stateReady();
}
function stateReady() {
	if(!(record===undefined || profile===undefined)){
		createChart();
	}
}
var chartId=0;
var emotion;
function reCreate() {
	var content = document.getElementsByTagName('svg');
	for(var i=0; i < content.length; i++) {
		console.log(content[i]);
		content[i].classList.add('hide');
	}
	
}
function createChart() {
	reCreate();
	spinner = document.createElement('i');
	var div = document.createElement('div');
	div.classList.add('middle-div');
	spinner.classList.add('fa');
	spinner.classList.add('fa-superpowers');
	spinner.classList.add('fa-spin');
	spinner.classList.add('fa-5x');
	div.appendChild(spinner);
	document.getElementById('chart-area').appendChild(div);
	chart();
}

function chart() {
	var url = "http://localhost:8080/MusicJ2EEBackEnd/Comments";
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			var data = JSON.parse(this.responseText);
			for(var i=0; i < data.length ; i++){
				createProgress(data[i].toneId,data[i].score);
			}
			var doc = document.getElementsByClassName('middle-div')[0];
			doc.remove();
		}else if(this.status <200&this.status>300){
			alert('couldn"t fetch content; check your connection');
		}
		
	};
	xhttp.open("POST",url, true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("profile="+profile+"&album="+record);
}

/* progression bar*/
function createProgress(emotion,score) {
	var width = 300,
    height = 200,
    twoPi = 2 * Math.PI; 

var dataset = {
                  progress: score*100,
                  total: 100
              };
 
var arc = d3.svg.arc()
    .innerRadius(50)
    .outerRadius(70)
    .startAngle(0);
 
var svg = d3.select("#chart-area").append("svg")
    .attr("width", width)
    .attr("height", height)
  .append("g")
    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")")

var meter = svg.append("g")
    .attr("class", "season-progress");
 
var background = meter.append("path")
    .datum({endAngle: twoPi})
    .style("fill", "#ddd")
    .attr("d", arc);
 
var foreground = meter.append("path")
    .datum({endAngle:0})
    .style("fill", "orange")
    .attr("class", "foreground")
    .attr("d", arc);
 
  foreground.transition()
    .duration(1000)
    .ease("linear")
    .attrTween("d", function(d) {
               var interpolate = d3.interpolate(d.endAngle, twoPi * dataset["progress"] / dataset["total"])
               return function(t) {
                  d.endAngle = interpolate(t);
                  return arc(d);
               }  
            });

  var text =  meter.append("text")
    .attr("text-anchor", "middle")
    .attr("dy", ".35em")
    .attr("font-size", "18")
    .attr("fill","#ffffff")
    .text(emotion +" " +Number(dataset["progress"]).toFixed(2));
}





