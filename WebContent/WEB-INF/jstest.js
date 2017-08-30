/**
 * 
 */

function runScript(e){
	if(e.keyCode ==13){
		var tb= document.getElementById("accountscript");
		eval(tb.value);
		return false;
	}
}