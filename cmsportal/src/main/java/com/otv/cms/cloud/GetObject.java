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
import com.otv.cms.builders.ErrorResponseEntityBuilder;
import com.otv.cms.exception.CMSException;
import com.otv.cms.utils.StreamUtils;
import com.otv.cms.web.pojo.Response.ErrorResponseEntity;

public final class GetObject {

  public static String readFromS3(String accessKey, String secretKey, String fileName,
      String bucketName) throws CMSException {

    BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
    AmazonS3 s3Client = AmazonS3ClientBuilder
        .standard()
        .withRegion(Regions.AP_SOUTH_1)
        .withCredentials(new AWSStaticCredentialsProvider(creds)).build();

    try {

      S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName, fileName));
      return StreamUtils.getStringFromInputStream(s3object.getObjectContent());

    } catch (AmazonServiceException ase) {
      ErrorResponseEntity errorResponseEntity = new ErrorResponseEntityBuilder()
          .withErrorCode(ase.getErrorCode())
          .withErrorMessage(ase.getMessage())
          .withHttpStatusCode(String.valueOf(ase.getStatusCode()))
          .withErrorType(ase.getErrorType().toString())
          .withRequestId(ase.getRequestId())
          .build();
      throw new CMSException(errorResponseEntity);

    } catch (AmazonClientException ace) {
      ErrorResponseEntity errorResponseEntity = new ErrorResponseEntityBuilder()
          .withErrorMessage(ace.getMessage())
          .build();
      throw new CMSException(errorResponseEntity);

    }
  }
}
