package pl.dmaksylewicz.java7.forkjoin.webcrawler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinWebCrawler implements LinkHandler {

	private final static String SITE_TO_VISIT = "http://jug.zgora.pl/";
	private final static int PARALLELISM_LEVEL = 15;
	private final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());

	private ForkJoinPool mainPool;
	private String url;

	public ForkJoinWebCrawler(String startingURL, int maxThreads) {
		this.url = startingURL;
		mainPool = new ForkJoinPool(maxThreads);
	}

	private void startCrawling() {
		mainPool.invoke(new LinkFinderRecursiveAction(this.url, this));
	}

	@Override
	public int size() {
		return visitedLinks.size();
	}

	@Override
	public void addVisited(String s) {
		visitedLinks.add(s);
	}

	@Override
	public boolean visited(String s) {
		return visitedLinks.contains(s);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Visiting site -> " + SITE_TO_VISIT);
		ForkJoinWebCrawler webCrawler = new ForkJoinWebCrawler(SITE_TO_VISIT, PARALLELISM_LEVEL);
		webCrawler.startCrawling();
		System.out.println("How many links processed ? " + webCrawler.size());
	}
}
