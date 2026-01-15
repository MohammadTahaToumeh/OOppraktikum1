package business;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.Bahnhof.Bahnhof;

public class Tests {
	private Bahnhof b;
	@Before
	public void setUp() throws Exception {
		String [] ein = {"ICE","IC","RE","RB","S"};
		b = new Bahnhof("Essen", "Essen1", 12, 14, ein);
	}

	@After
	public void tearDown() throws Exception {
		b =  null;
	}

	@Test
	public void test() {
		assertTrue(()->b.getName().equals("Essen"));
		Throwable exc = assertThrows(IllegalArgumentException.class, () -> new Bahnhof("Essen", "ca", 2, 5, null));
	}

	

}
