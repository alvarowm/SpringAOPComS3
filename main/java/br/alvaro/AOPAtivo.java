package br.alvaro;

import br.alvaro.ativo.model.AtivoModel;
import br.alvaro.s3.S3BucketWorker;

public class AOPAtivo {

	public void logToS3MemoriaDecalculo(Object ativo) {
		new S3BucketWorker((AtivoModel) ativo).sendToBucket();
	}

}
