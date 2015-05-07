package net.zx.testing;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ParameterizedTester {
	private int r;
	private int a;
	private int b;
	
	@Parameters
	static public Iterable<Object[]> ps()  {
		return Arrays.asList(new Object[][]{{10, 4, 6}, {12, 9, 3}});
	};
	
	public ParameterizedTester(int result, int ia, int ib) {
		r = result;
		a = ia;
		b = ib;
	}
	
	@Test
	public void testerAdd() {
		Assert.assertEquals(r,  a+b);
	}
}
