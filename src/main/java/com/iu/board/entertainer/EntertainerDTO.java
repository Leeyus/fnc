package com.iu.board.entertainer;

import com.iu.board.BoardDTO;

public class EntertainerDTO extends BoardDTO{
	
	private String sub_img;
	private String sub_contents;
	
	
	

	public String getSub_contents() {
		return sub_contents;
	}

	public void setSub_contents(String sub_contents) {
		this.sub_contents = sub_contents;
	}

	public String getSub_img() {
		return sub_img;
	}

	public void setSub_img(String sub_img) {
		this.sub_img = sub_img;
	}
}
