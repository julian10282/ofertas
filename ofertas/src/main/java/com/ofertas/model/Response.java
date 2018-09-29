package com.ofertas.model;

import com.ofertas.enumerator.ResponseEnum;

public class Response {

	private Long status;
	private String reason;
	private Object body;
	
	public Response() {
		super();
	}

	public Response(String reason) {
		super();
		this.reason = reason;
	}
	
	public Response(Long status, String reason) {
		super();
		this.status = status;
		this.reason = reason;
	}
	
	public Response(ResponseEnum publishResponseEnum){
		this.status = publishResponseEnum.getStatus();
		this.reason = publishResponseEnum.getReason();
	}

	public Response(Long status, String reason, Object body) {
		super();
		this.status = status;
		this.reason = reason;
		this.body = body;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublishResponse [status=");
		builder.append(status);
		builder.append(", reason=");
		builder.append(reason);
		builder.append(", body=");
		builder.append(body);
		builder.append("]");
		return builder.toString();
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
}
