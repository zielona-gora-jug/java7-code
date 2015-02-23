package pl.dmaksylewicz.java7.forkjoin.webcrawler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class LinkFinderRecursiveAction extends RecursiveAction {

	private static final long serialVersionUID = 3531217505375212737L;
	private static final int NUMBER_OF_LINKS_TO_VISIT = 100;
	private static final long NOW = System.currentTimeMillis();

	private LinkHandler handler;
	private String url;

	public LinkFinderRecursiveAction(String url, LinkHandler handler) {
		this.url = url;
		this.handler = handler;
	}

	@Override
	public void compute() {
		if (handler.visited(url)) {
			return;
		}
		try {
			// System.out.println("current thread name -> " + Thread.currentThread().getName());
			List<RecursiveAction> actions = new ArrayList<RecursiveAction>();
			URL uri = new URL(url);
			Parser parser = new Parser(uri.openConnection());
			NodeList list = parser.extractAllNodesThatMatch(new NodeClassFilter(LinkTag.class));
			for (int i = 0; i < list.size(); i++) {
				LinkTag tag = (LinkTag) list.elementAt(i);
				String link = tag.extractLink();
				boolean isLinkNotEmpty = !link.isEmpty();
				boolean isLinkNotVisited = !handler.visited(link);
				if (isLinkNotEmpty && isLinkNotVisited) {
					// System.out.println("jump deeper...link -> " + extractLink);
					actions.add(new LinkFinderRecursiveAction(link, handler));
				}
			}
			handler.addVisited(url);
			if (handler.size() == NUMBER_OF_LINKS_TO_VISIT) {
				long howLong = (System.currentTimeMillis() - NOW) / 1000;
				System.out.println("Time for visit " + NUMBER_OF_LINKS_TO_VISIT + " distinct links = " + howLong + " sec");
				System.exit(0);
			}
			invokeAll(actions);
		} catch (ParserException | IOException e) {
			// e.printStackTrace();
		}
	}
}
