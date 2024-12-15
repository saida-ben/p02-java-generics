package org.mql.java.generics;

import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class TestRunner {

	public TestRunner() {
		//strcture de code permet de  LauncherFactory executer requete (mais as le res) de test piur recup resulat on utilise listener 
		Launcher launcher = LauncherFactory.create();
		SummaryGeneratingListener listener = new SummaryGeneratingListener();
		launcher.registerTestExecutionListeners(listener);
		
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
				.request()
				.selectors(DiscoverySelectors.selectClass(VectorTest.class))
				.build(); // opp final construction luncherdiscoveryrequest
		
		launcher.execute(request);
		
		TestExecutionSummary summary = listener.getSummary();
		System.out.println("Test Fount count" + summary.getTestsFoundCount());
		System.out.println("Test failed count" + summary.getTestsFailedCount());
		System.out.println("Test succeed count" + summary.getTestsSucceededCount());


	}
	
	public static void main(String[] args) {
		new TestRunner();
	}

}
