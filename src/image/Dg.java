package image;

import java.io.File;

public class Dg {
	public File nextFile(File file) {
		File f[] = new File[5000];
		
		f = file.getParentFile().listFiles(new ImageFileFilter());
		int max = f.length;
		max = max - 1;
		
	
		// System.out.println(file);
		for (int i = 0; i < f.length; i++) {
			
				if (f[i].equals(file)) {

					if (i + 1 > max) {
						return f[0];
					} else {
						return f[i + 1];
					}

				} else {
					// System.out.println(0);
					// return file;
				}
			}
		
		return file;

}

	public File priFile(File file) {
		File f[] = new File[5000];
		f = file.getParentFile().listFiles(new ImageFileFilter());
		int min = 0;
		// System.out.println(file);
		for (int i = 0; i < f.length; i++) {
			if (f[i].equals(file)) {
				min = i - 1;
				if (min < 0) {
					return f[f.length-1];
				} else {
					return f[min];
				}
			} else {
				// System.out.println(0);
				// return file;
			}
		}
		return file;

	}
	
}