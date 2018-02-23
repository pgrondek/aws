package pl.grondek.aws.lambda.s3;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.List;
import java.util.stream.Collectors;

public class ListS3Lambda implements RequestHandler<Void, List<String>> {
    @Override
    public List<String> handleRequest(Void input, Context context) {
        final String bucketName = System.getenv("BUCKET_NAME");
        final String bucketRegion = System.getenv("REGION");

        return AmazonS3ClientBuilder.standard()
                .withRegion(bucketRegion)
                .build()
                .listObjects(bucketName)
                .getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
    }
}
