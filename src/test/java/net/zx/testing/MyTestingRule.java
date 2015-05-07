package net.zx.testing;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyTestingRule implements TestRule {
	
	public Statement apply (final Statement base, Description des) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable{
				base.evaluate();
			}
		};
	}
}
