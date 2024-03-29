package br.com.orlandoburli.euvouromper.web.servlets.utils.indexer;

import java.io.File;

public class DeleteDir {

	public static void delete(String path) {
		deleteDirectory(new File(path));
	}

	static public boolean deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return (path.delete());
	}
}