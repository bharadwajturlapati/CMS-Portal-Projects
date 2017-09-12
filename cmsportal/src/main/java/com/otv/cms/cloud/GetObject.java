package com.otv.cms.cloud;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.otv.cms.utils.StreamUtils;

public final class GetObject {

  public static String readFromS3(String accessKey, String secretKey, String fileName,
      String bucketName) {

    BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
    AmazonS3 s3Client = AmazonS3ClientBuilder
        .standard()
        .withRegion(Regions.AP_SOUTH_1)
        .withCredentials(new AWSStaticCredentialsProvider(creds)).build();

    try {
      S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName, fileName));
      return StreamUtils.getStringFromInputStream(s3object.getObjectContent());
    } catch (AmazonServiceException ase) {
      System.out.println("Error Message:    " + ase.getMessage());
      System.out.println("HTTP Status Code: " + ase.getStatusCode());
      System.out.println("AWS Error Code:   " + ase.getErrorCode());
      System.out.println("Error Type:       " + ase.getErrorType());
      System.out.println("Request ID:       " + ase.getRequestId());

    } catch (AmazonClientException ace) {
      System.out.println(ace.toString());
    }
    return "";
  }
}
