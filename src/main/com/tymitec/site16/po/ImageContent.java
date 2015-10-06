package site16.po;

public class ImageContent {

	private String id;

	private String path;
	
	private String fileName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String  toString(){
		return path + "/" + fileName;
	}
	
}
