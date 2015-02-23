package pl.dmaksylewicz.java7.forkjoin.webcrawler;

public interface LinkHandler {

	int size();

	boolean visited(String link);

	void addVisited(String link);
}
