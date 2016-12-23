function printValue(sliderID, text) {
	var x = document.getElementById(sliderID);
	var y = document.getElementById(text);
	y.innerHTML = (x.value / 10) + " giây";
}
