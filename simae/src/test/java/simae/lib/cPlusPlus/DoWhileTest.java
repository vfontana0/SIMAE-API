package simae.lib.cPlusPlus;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import simae.SimaeLauncher;
import simae.lib.Lenguaje;

class DoWhileTest extends Tests {

	
	@Test
	void testDoWhile() throws IOException {
		  prog = "int main() {" + nl +
		  		"	do {" + nl +
		  		"	} while(c<0);" + nl +
		  		"}" + nl;
		  esperado = "int main()/*/CIERRA EN LINEA 4/*/ {" + nl + 
		  		"	do/*/CIERRA EN LINEA 3/*/ {" + nl + 
		  		"	} while(c<0);/*/CIERRA do while DE LINEA 2/*/" + nl +
		  		"}/*/CIERRA main() DE LINEA 1/*/" + nl;
		  marcado = SimaeLauncher.launchTagging(prog, Lenguaje.CPLUSPLUS, "es");

		  assertEquals(esperado,marcado, "No son iguales.");
	}
}
