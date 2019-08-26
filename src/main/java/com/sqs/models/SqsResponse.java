package com.sqs.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SqsResponse {
	
	@JsonProperty
	private String MD5OfMessageBody;
	
	public String getMD5OfMessageBody() {
		return MD5OfMessageBody;
	}

	public void setMD5OfMessageBody(String mD5OfMessageBody) {
		MD5OfMessageBody = mD5OfMessageBody;
	}

	public String getMessageId() {
		return MessageId;
	}

	public void setMessageId(String messageId) {
		MessageId = messageId;
	}

	@JsonProperty
	private String MessageId;

	@Override
	public String toString() {
		return "SqsResponse [MD5OfMessageBody=" + MD5OfMessageBody + ", MessageId=" + MessageId + "]";
	}
	
}
