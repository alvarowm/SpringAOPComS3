package br.alvaro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.alvaro.ativo.bo.AtivoBO;
import br.alvaro.ativo.model.AtivoModel;

public class Main {

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AtivoBO bo = context.getBean(AtivoBO.class);	
		
		AtivoModel ativo = new AtivoModel();
		ativo.setCodigoDoAtivo("PETR4");
		ativo.setNomeDoAtivo("PETROBRAS PN EDJ N2");
		ativo.setPrecoDoAtivo(28.76f);
		
		bo.setAtivo(ativo);
		
		bo.calcularTaxa();
	}

}
