package framework;

public class File extends FolderItem {
	private String extension;
	private int size;

	public File(String initialName, String initialExtension, int initialSize) {
		super(initialName);
		extension = initialExtension;
		size = initialSize;
	}

	public String getExtension() {
		return extension;
	}

	public int getSize() {
		return size;
	}

	public void setExtension(String newExtension) {
		extension = newExtension;
	}
}
