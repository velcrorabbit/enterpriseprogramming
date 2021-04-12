// Show the time in the city whose name is given
// by the textfield whose id is "city-1". Use GET.

function showAllFilmsByDataType(inputField, resultRegion) {
	var baseAddress = "getAllFilms";
	var data = "dataType=" + getValue(inputField);
	var address = baseAddress + "?" + data;
	ajaxResult(address, resultRegion);
}