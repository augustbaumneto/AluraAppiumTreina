package com.alura.appium.AluraAppium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;

import static com.alura.appium.AluraAppium.Log.Log.getLog;

import com.alura.appium.AluraAppium.PageObjects.CadastroPageObject;
import com.alura.appium.AluraAppium.PageObjects.LoginPageObject;

import io.appium.java_client.AppiumDriver;



public class FeatureCadastro 
{
	private Logger logger = getLog();
	
    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem()
    {
    	logger.info(("Inicio teste: Não cadastrar usuário"));
    	
    	AppiumDriver driver = AppiumDriverConfig.Instance().driver; 
    	
    	LoginPageObject telalogin = new LoginPageObject(driver); 
    	
    	logger.info("Driver e tela de login incializada");
    	
    	telalogin.buscarElementos();
    	CadastroPageObject telacadastro = telalogin.clicarCadastrar();
    	
    	logger.info("Avanço tela de Cadastro");
    	
    	telacadastro.buscarElementos();
    	telacadastro.Cadastrar("Usuario 1","123","456");
    	
    	
        assertEquals(telacadastro.verificamensagemerro(), "Senhas não conferem");
        
        logger.info("Validação do cadastro efetuada");
        
        telacadastro.voltarLogin();
        
        logger.info("Retorno tela de login");

        
    }
    
    @Test
    public void efetuar_cadastro_usuario_e_senhas_validos()
    {
    	logger.info(("Inicio teste: Cadastro usuário"));
    	AppiumDriver driver = AppiumDriverConfig.Instance().driver; 
    	
    	LoginPageObject telalogin = new LoginPageObject(driver); 
    	
    	logger.info(("Driver e tela login instanciado"));
    	
    	telalogin.buscarElementos();
    	CadastroPageObject telacadastro = telalogin.clicarCadastrar();
    	
    	logger.info("Avanço tela de Cadastro");
    	
    	telacadastro.buscarElementos();
    	telalogin = telacadastro.Cadastrar("Usuario 1","123","123");
    	    	  	
        assertTrue(telalogin.estaTelaLogin());
        
        logger.info("Validação do cadastro efetuada");
        
    }
}
