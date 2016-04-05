package site16.po;

/**
 * イメージ情報クラス
 * 
 * @author bretwang
 * @since 2015/10/29
 * @version 1.0
 */
public class ImageContent {

	//イメージId
	private String id;

	//
	private String order;
	
	//Folder
	private String path;
	
	//ファイル名
	private String fileName;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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
