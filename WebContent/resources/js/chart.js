/**
 * 
 */
var profileContainer = document.getElementsByClassName('list-container')[0];
profileContainer.addEventListener('click',function (event) {
	createChart(event);
});
var chartId=0;
var month = new Array();
	month[0] = "January";
	month[1] = "February";
	month[2] = "March";
	month[3] = "April";
	month[4] = "May";
	month[5] = "June";
	month[6] = "July";
	month[7] = "August";
	month[8] = "September";
	month[9] = "October";
	month[10] = "November";
	month[11] = "December";
	
function createChart(event) {
	var element = event.srcElement;
	var id = element.dataset.profile;
	reCreate();
	if(id=="linechart"){
		createLineChart();
	} else {
	chart(id,'bar');
	}
}
function reCreate() {
	var content = document.getElementsByClassName('graphical-report__layout')[chartId++]; 
	content.classList.add('hide');
} 

function createLineChart() {
	
	var url = "FanLineCharter";
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		
		if (this.readyState == 4 && this.status == 200) {
			var chartDetails = JSON.parse(this.responseText);
			chartDetails['settings'] = {
					fitModel: 'entire-view'
				  }
			chartDetails["plugins"] = [
		        tauCharts.api.plugins.get('tooltip')({
		            // will see only name and age on tooltip
		            fields: ['fanCount','queryDate','profileId','mediaName'],
		            formatters: {
		            	queryDate : {
		            		label : "Month",
		        			format : function (queryDate) {
		        				var date = new Date(queryDate);
		        				return month[date.getMonth()];
		        			}
		            	},
		        	fanCount : {
		        		label : "Fans"
		        	},
		        	profileId : {
		        		label : "Profile Name"
		        	},
		        	mediaName : {
		        		label : "social media"
		        	}
		            	
		            }
		        }),
		        tauCharts.api.plugins.get('legend')()
		    ];
			
			var charter = new tauCharts.Chart(chartDetails);
			charter.renderTo("#my-chart");
		}else if(this.status <200&this.status>300){
			alert('couldn"t fetch content; check your connection');
		}
	};
	xhttp.open("POST",url, true);
	xhttp.send();
}
createLineChart();


 
function chart(profileId,chartType) {
	var url="FanCountChart";
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var chartDetails = JSON.parse(this.responseText);
			chartDetails['settings'] = {
			  	fitModel: 'entire-view'
			  }
			chartDetails["plugins"] = [
		        tauCharts.api.plugins.get('tooltip')({
		            // will see only name and age on tooltip
		            fields: ['fanCount','queryDate','profileId'],
		            formatters: {
		            	queryDate : {
		            		label : "Month",
		        			format : function (queryDate) {
		        				var date = new Date(queryDate);
		        				return month[date.getMonth()];
		        			}
		            	},
		            	fanCount : {
			        		label : "Fans"
			        	},
			        	profileId : {
			        		label : "Profile Name"
			        	}
		            }
		        }),
		        tauCharts.api.plugins.get('quick-filter')()
		    ];
			
			var charter = new tauCharts.Chart(chartDetails);
			charter.renderTo("#my-chart");
		}else if(this.status <200&this.status>300){
			alert('couldn"t fetch content; check your connection');
		}
	};
	xhttp.open("POST",url, true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("profileId="+profileId+"&chartType="+chartType);
	
}