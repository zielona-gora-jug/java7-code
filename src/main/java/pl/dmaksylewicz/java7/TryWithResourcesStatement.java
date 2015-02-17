package pl.dmaksylewicz.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryWithResourcesStatement {

	private final static int PING_STATUS_OK = 1;

	public String readSingleLine(String path) throws IOException {
		try (FileReader reader = new FileReader(path); BufferedReader buf = new BufferedReader(reader)) {
			return buf.readLine();
		}
	}

	// Java < 7

	public String throwExceptionWhenReadSingleLineBefore(String path) throws IOException {
		FileReader reader = null;
		BufferedReader buf = null;
		try {
			reader = new FileReader(path);
			buf = new MyBufferedReader(reader);
			return buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (buf != null) {
				buf.close();
			}
		}
	}

	// Java >= 7

	public String throwExceptionWhenReadSingleLineAfter(String path) throws IOException {
		try (FileReader reader = new FileReader(path); BufferedReader buf = new MyBufferedReader(reader)) {
			return buf.readLine();
		}
	}

	public int ping() throws Exception {
		// need to catch exception thrown by overridden close
		try (MyAutoCloseableResource res = new MyAutoCloseableResource()) {
			return PING_STATUS_OK;
		}
	}

	private class MyAutoCloseableResource implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("AutoCloseable rocks ! ");
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
