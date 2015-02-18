package pl.dmaksylewicz.java7;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileWatcher {

	private static void watch(String path) throws IOException, InterruptedException {
		WatchService watcher = FileSystems.getDefault().newWatchService();
		Path pathToWatch = FileSystems.getDefault().getPath(path);
		WatchKey watchKey = pathToWatch.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
		for (;;) {
			WatchKey key = watcher.take();
			if (key.equals(watchKey)) {
				for (WatchEvent<?> event : key.pollEvents()) {
					System.out.println(pathToWatch + " : new file create -> " + event.context());
				}
			}
			key.reset();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		final String pathToWatch = "./src/main/resources/";
		watch(pathToWatch);
	}
}
