package simae.lib.python;

import org.junit.jupiter.api.Test;
import simae.SimaeLauncher;
import simae.lib.Lenguaje;
import simae.lib.cPlusPlus.Tests;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IfTest extends Tests {

	
	@Test
	void ifTest() throws IOException {
		  prog = "a = 33" + nl +
				  "b = 200" + nl +
				  "if b > a:" + nl +
				  "  print(\"b is greater than a\")" + nl;
		  esperado = "a = 33" + nl +
				  "b = 200" + nl +
				  "if b > a:# /CIERRA EN LINEA 4/" + nl +
				  "  print(\"b is greater than a\")# /CIERRA if b > a DE LINEA 3/" + nl;
		  marcado = SimaeLauncher.launchTagging(prog, Lenguaje.PYTHON3, "es");
		  assertEquals(esperado,marcado, "No son iguales.");
	}
}
