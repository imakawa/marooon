package site16.viewdata;

import site16.po.ImageComment;
import site16.po.ImageContent;

public class ImageViewData {

	private ImageComment comment;

	private ImageContent content;

	public ImageViewData(ImageContent iContent, ImageComment iComment) {
		content = iContent;
		comment = iComment;
	}

	public ImageComment getComment() {
		return comment;
	}

	public void setComment(ImageComment comment) {
		this.comment = comment;
	}

	public ImageContent getContent() {
		return content;
	}

	public void setContent(ImageContent content) {
		this.content = content;
	}

}
