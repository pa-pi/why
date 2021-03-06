package am.why.java;

import am.why.java.interpreter.Interpreter;
import am.why.java.scanner.YScanner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adrian on 05.05.2017.
 */
public class CodegolfTests {

	@Test
	public void swapTheParity() { //https://codegolf.stackexchange.com/questions/118819/swap-the-parity
		YScanner yScanner = new YScanner("(EDOI");
		//assertEquals(true, yScanner.checkSyntax());
		yScanner.parse();
		Interpreter interpreter = new Interpreter(yScanner, "1,2,3,4,5,6,7,8,313,314", true);
		interpreter.interpret();
		String result[] = {"2", "1", "4", "3", "6", "5", "8", "7", "314", "313"};
		for (String s : interpreter.getHistory()) {
			System.out.println(s);
		}
		for (int i = 0; i < result.length; i++) {
			assertEquals(result[i], interpreter.getStorage().getArray()[i]);
		}
	}

	public void swapTheAlphabet() {
		//https://codegolf.stackexchange.com/questions/68504/swap-the-alphabet?rq=1
	}

	@Test
	public void isThisNumberAPrime() {
		//https://codegolf.stackexchange.com/questions/57617/is-this-number-a-prime?noredirect=1&lq=1
		YScanner yScanner = new YScanner("0p");
		yScanner.parse();
		Interpreter interpreter = new Interpreter(yScanner, "1,2,3,4,5,6,7,8,9,11,13,7919", true);
		interpreter.interpret();
		String result[] = {"false", "true", "true", "false", "true", "false", "true", "false", "false", "true", "true", "true"};
		for (int i = 0; i < interpreter.getStorage().getArray().length; i++) {
			assertEquals(result[i], interpreter.getStorage().getArray()[i]);
		}
	}
}
