package com.example.domain;

public class ValMapNotFoundException extends RuntimeException {

	public ValMapNotFoundException(Long postId) {
		super(String.format("post id:%s not found!", postId));
	}

}
