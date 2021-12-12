package br.alvaro.s3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import br.alvaro.ativo.model.AtivoModel;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3BucketWorker {
	
	AtivoModel ativo; 
	
	public S3BucketWorker (AtivoModel ativo) {
		this.ativo = ativo;
	}	
    
    private void setupAndSend() {
    	Region region = Region.US_WEST_2;
        S3Client s3 = S3Client.builder().region(region).build();
        
        String strBucket = createBuckerStr();
        
        UUID uuid = UUID.randomUUID();
        String bucketName = uuid.toString();
        
        createBucket(region, s3, bucketName);
        
        waitBucketCreation(s3, bucketName);
        
        String key = readPropFileKey();
        
        send(s3, bucketName, key, strBucket);
        
        s3.close();
        
    }

	private String readPropFileKey() {
		InputStream input;
        Properties prop = null;
		try {
			input = new FileInputStream("src/main/resources/application.properties");
			prop = new Properties();
		    prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
       
        String key = prop.getProperty("aws.key");
		return key;
	}

	private void waitBucketCreation(S3Client s3, String bucketName) {
		s3.waiter().waitUntilBucketExists(HeadBucketRequest.builder()
                .bucket(bucketName)
                .build());
	}

	private void createBucket(Region region, S3Client s3, String bucketName) {
		s3.createBucket(CreateBucketRequest
                .builder()
                .bucket(bucketName)
                .createBucketConfiguration(
                    CreateBucketConfiguration.builder()
                        .locationConstraint(region.id())
                        .build())
                .build());
	}

	private String createBuckerStr() {
		StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Transação do ativo\n");
        strBuilder.append("--------------------------------------------\n");
        strBuilder.append(ativo.getNomeDoAtivo() + System.lineSeparator());
        strBuilder.append(ativo.getCodigoDoAtivo() + System.lineSeparator());
        strBuilder.append(ativo.getPrecoDoAtivo()+ System.lineSeparator());
        strBuilder.append("Taxa: " + ativo.getTaxa() + System.lineSeparator());
        strBuilder.append("--------------------------------------------");
        String strBucket = strBuilder.toString();
		return strBucket;
	}
    
    public void sendToBucket() {
    	setupAndSend();
    }

	private void send(S3Client s3, String bucketName, String key, String strBucket) {
		s3.putObject(PutObjectRequest.builder().bucket(bucketName).key(key)
                .build(),
            RequestBody.fromString(strBucket));
		
	}
    
}
