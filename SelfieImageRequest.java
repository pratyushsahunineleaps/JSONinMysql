package com.example.crifdemo.bean;

import java.io.Serializable;
import java.util.UUID;

public class SelfieImageRequest implements Serializable{
	 
		private static final long serialVersionUID = 1L;
		
		private UUID userId;
		private UUID uuId;
		private int retryCount;
		private int selfieImageRetryCount;
		
		
		
		private SelfieImageResponse selfieImageResponse;
		private ExternalSelfieRequestDetails externalSelfieRequestDetails;

		public UUID getUserId() {
			return userId;
		}
		public void setUserId(UUID userId) {
			this.userId = userId;
		}
		public UUID getUuId() {
			return uuId;
		}
		public void setUuId(UUID uuId) {
			this.uuId = uuId;
		}
		
		public SelfieImageResponse getSelfieImageResponse() {
			return selfieImageResponse;
		}
		public void setSelfieImageResponse(SelfieImageResponse selfieImageResponse) {
			this.selfieImageResponse = selfieImageResponse;
		}
		public ExternalSelfieRequestDetails getExternalSelfieRequestDetails() {
			return externalSelfieRequestDetails;
		}
		public void setExternalSelfieRequestDetails(ExternalSelfieRequestDetails externalSelfieRequestDetails) {
			this.externalSelfieRequestDetails = externalSelfieRequestDetails;
		}
		public int getRetryCount() {
			return retryCount;
		}
		public void setRetryCount(int retryCount) {
			this.retryCount = retryCount;
		}
		
		public int getSelfieImageRetryCount() {
			return selfieImageRetryCount;
		}
		public void setSelfieImageRetryCount(int selfieImageRetryCount) {
			this.selfieImageRetryCount = selfieImageRetryCount;
		}
		@Override
		public String toString() {
			return "SelfieImageRequest [userId=" + userId + ", uuId=" + uuId + ", retryCount=" + retryCount
					+ ", selfieImageRetryCount=" + selfieImageRetryCount + ", selfieImageResponse=" + selfieImageResponse
					+ ", externalSelfieRequestDetails=" + externalSelfieRequestDetails + "]";
		}
		
}
