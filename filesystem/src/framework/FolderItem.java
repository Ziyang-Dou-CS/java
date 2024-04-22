package framework;

public class FolderItem {
	private String name;

	public FolderItem(String initialName) {
		name = initialName;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
}
