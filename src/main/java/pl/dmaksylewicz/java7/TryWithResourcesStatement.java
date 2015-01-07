package pl.dmaksylewicz.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryWithResourcesStatement {

	public String readFirstLineWhenOneRecource(String path) throws IOException {
		try (BufferedReader buf = new BufferedReader(new FileReader(path))) {
			return buf.readLine();
		}
	}

	public String readFirstLineWhenMoreResources(String path) throws IOException {
		try (FileReader reader = new FileReader(path); BufferedReader buf = new BufferedReader(reader)) {
			return buf.readLine();
		}
	}

	public String throwSuppressedException(String path) throws IOException {
		try (FileReader reader = new FileReader(path); BufferedReader buf = new MyBufferedReader(reader)) {
			return buf.readLine();
		}
	}

	private class MyBufferedReader extends BufferedReader {

		public MyBufferedReader(Reader in) {
			super(in);
		}

		@Override
		public String readLine() throws IOException {
			throw new RuntimeException("read line ex");
		}

		@Override
		public void close() throws IOException {
			throw new RuntimeException("close ex");
		}
	}
}
