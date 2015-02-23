package pl.dmaksylewicz.java7.syntax;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class Watcher {

	private static final String PATH_TO_WATCH = "./src/main/resources/";

	// 4 key new classes come with new I/O API -> java.nio.file.Paths,
	// java.nio.file.Path, java.nio.file.Files, java.nio.file.FileSystem

	private static void watch() throws IOException, InterruptedException {
		WatchService watcher = FileSystems.getDefault().newWatchService();
		Paths.get(PATH_TO_WATCH).register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		while (true) {
			System.out.println("listening...");
			WatchKey watckKey = watcher.take();
			for (WatchEvent<?> event : watckKey.pollEvents()) {
				System.out.println(event.kind().toString() + " -> " + event.context().toString());
			}
			boolean valid = watckKey.reset();
			if (!valid) {
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("starting watcher...");
		watch();
	}
}
