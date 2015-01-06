package pl.dmaksylewicz.java7;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesStatement {

	public String readFirstLineWhenOneRecource(String path) throws IOException {
		try (BufferedReader buff = new BufferedReader(new FileReader(path))) {
			return buff.readLine();
		}
	}

	public String readFirstLineWhenMoreResources(String path) throws IOException {
		try (FileReader reader = new FileReader(path); BufferedReader buff = new BufferedReader(reader)) {
			return buff.readLine();
		}
	}

	public String throwSuppressedException(String path) throws IOException {
		FileReader reader = null;
		BufferedReader buff = null;
		try {
			reader = new FileReader(path);
			buff = new BufferedReader(reader);
			throw new EOFException("try / finally exception");
		} finally {
			if (reader != null) {
				reader.close();
				throw new EOFException("finally exception");
			}
			if (buff != null) {
				buff.close();
			}
		}
	}
}
