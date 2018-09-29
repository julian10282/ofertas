package com.ofertas.enumerator;

public enum ResponseEnum {
	SUCCESS(200L,"Success in process"),
	BAD_REQUEST(400L,"Bad parameter request"),
	UNAUTHORIZED(401L,"Unauthorized authentication"),
	NO_CONTENT(204L,"No data found for parameters"),
	INTERNAL_ERROR(500L,"Internal server error"),
	SERVICE_UNAVAILABLE(503L,"Service unavailable or not responding");
	
	private Long status;
	private String reason;
	
	ResponseEnum(Long status, String reason){
		this.status = status;
		this.reason = reason;
	}

	public Long getStatus() {
		return status;
	}

	public String getReason() {
		return reason;
	}

}


