package ku.util;

import stopwatch.Stopwatch;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	public static void copy(InputStream in, OutputStream out) {
		try {
			int readByte;
			while ((readByte = in.read()) != -1)
				out.write(readByte);
			in.close();
			out.close();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public static void copy(InputStream in, OutputStream out, int blocksize) {
		try {
			byte[] buffer = new byte[blocksize];
			int count;
			while ((count = in.read(buffer)) != -1)
				out.write(buffer);
			in.close();
			out.close();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public static void bcopy(InputStream in, OutputStream out) {
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
			PrintWriter printer = new PrintWriter(out);
			String read;
			while ((read = buffer.readLine()) != null)
				printer.write(read + "\n");
			in.close();
			out.close();

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public static void bcharcopy(InputStream in, OutputStream out){
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
			BufferedWriter printer = new BufferedWriter(new OutputStreamWriter(out));
			char[] x = new char[10_000];
			int length;
			while ((length = buffer.read(x)) != -1)
				printer.write(x, 0, length);
			in.close();
			out.close();

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}


}
