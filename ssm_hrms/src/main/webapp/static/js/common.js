
function getDefaultString(input) {
	if (input == null || input == "") {
		return "--";
	} else {
		return input;
	}
}

function getLimitString(input) {
	if (input == null || input == "") {
		return "--";
	} else {
		return input.substring(0,5)+"......";
	}
}

function getDefaultDateString(input) {
	if (input == null || input == "") {
		return "--";
	} else {
		return new Date(input).format("yyyy-MM-dd");
	}
}