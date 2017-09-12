package com.otv.cloud.awsengine;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class GetObject {

	private String bucketName = "";
	private String access_key = "";
	private String secret_key = "";
	

	public GetObject(String bucketName, String access_key, String secret_key) {
		this.bucketName = bucketName;
		this.access_key = access_key;
		this.secret_key = secret_key;
	}

	public String readFromS3() {//throws CloudExceptionContainer {
		BasicAWSCredentials creds = new BasicAWSCredentials(access_key, secret_key); 
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).build();
		try {
			S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName, secret_key));
			System.out.println("Content-Type: " + s3object.getObjectMetadata().getContentType());
			return "";
			//return StreamUtils.getStringFromInputStream(s3object.getObjectContent());
		} catch (AmazonServiceException ase) {
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
			//throw new CloudExceptionContainer(ase.getMessage(), ase.getStatusCode(), ase.getErrorCode(),
				//	ase.getErrorType(), ase.getRequestId());
		} catch (AmazonClientException ace) {
			//throw new CloudExceptionContainer(ace.getMessage(), ErrorCodes.S3_SERVICE_HTTP_FAILURE_CODE, "", null, "");
		}
		return "";
	}
}
