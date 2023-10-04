
var chartDataStr = decodeHtml(chartData);
var chartJsonArray=JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];
for(var i = 0; i<arrayLength;i++){
	numericData[i]=chartJsonArray[i].number;
	labelData[i]=chartJsonArray[i].label;
}
//For a pie chart
new Chart(document.getElementById("myPieChart"),{
	type:'pie',
	//The data for our dataset
	data:{
		labels:labelData,
		datasets:[{
			label:'My First dataset',
			backgroundColor: ['#008000','#FFA500','#FF0000'],
			borderColor: '#FFFFFF',
			data:numericData
		}]
	},
	//Config goes here
	options:{
		title:{
			display:true,
			text:'Project Status'
		}
	}
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}