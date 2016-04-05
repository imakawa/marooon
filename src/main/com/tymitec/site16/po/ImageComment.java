package site16.po;

/**
 * イメージコメントクラス
 * 画面については、イメージごとに下部のコメント
 * 
 * @author bretwang
 * @since 2015/10/29
 * @version 1.0
 */
public class ImageComment {
	
	//当イメージコメントのId
	private String id;

	//当イメージのIｄ
	private String imgId;
	
	//当イメージのOK数
	private int up = 0;

	//当イメージのNG数
	private int down = 0;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}
}
