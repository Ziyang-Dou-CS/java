package framework;

import java.util.Vector;

public class Folder extends FolderItem {
	private Vector<FolderItem> folderItems;

	public Folder(String initialName) {
		super(initialName);
		folderItems = new Vector<FolderItem>();

	}

	public Vector<FolderItem> getFolderItems() {
		return folderItems;
	}

	public void setFolderItems(Vector<FolderItem> newFolderItems) {
		folderItems = newFolderItems;
	}

	public void addFolderItem(FolderItem item) {
		folderItems.add(item);
	}

	public void removeFolderItem(FolderItem item) {
		folderItems.remove(item);
	}

	public FolderItem getFolderItem(int index) {
		return folderItems.get(index);
	}

	public int getNumberOfFolderItems() {
		return folderItems.size();
	}
}
