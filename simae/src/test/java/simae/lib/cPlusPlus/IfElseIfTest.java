package simae.lib.cPlusPlus;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import simae.SimaeLauncher;
import simae.lib.Lenguaje;

class IfElseIfTest extends Tests {

	
	@Test
	void testIfElseIf() throws IOException {
		  prog = "int main() {" + nl +
		  		"	if(c == 1) {" + nl +
		  		"		c++;" + nl +
		  		"	}" + nl +
		  		"	else if(c) {" + nl +
		  		"		c--;" + nl +
		  		"	}" + nl +
		  		"}" + nl;
		  esperado = "int main()/*/CIERRA EN LINEA 8/*/ {" + nl +
		  		"	if(c == 1)/*/CIERRA EN LINEA 4/*/ {" + nl +
		  		"		c++;" + nl +
		  		"	}/*/CIERRA if(c == 1) DE LINEA 2/*/" + nl +
		  		"	else/*/CIERRA EN LINEA 7/*/ if(c)/*/CIERRA EN LINEA 7/*/ {" + nl +
		  		"		c--;" + nl +
		  		"	}/*/CIERRA if(c) DE LINEA 5 y CIERRA else DE LINEA 5/*/" + nl +
		  		"}/*/CIERRA main() DE LINEA 1/*/" + nl;
		  marcado = SimaeLauncher.launchTagging(prog, Lenguaje.CPLUSPLUS, "es");
		  assertEquals(esperado,marcado, "No son iguales.");
	}
}
