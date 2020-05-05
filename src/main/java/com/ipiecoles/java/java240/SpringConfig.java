package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean
    @Scope("singleton")//équivalent à ne rien mettre ou mettre @Scope("")
    public BitcoinService bitcoinService(){
        System.out.println("Instantiation du bean BitcoinService par Spring");
        BitcoinService bitcoinService = new BitcoinService(webPageManager());
        return bitcoinService;
    }

    @Bean
    @Scope("singleton")//équivalent à ne rien mettre ou mettre @Scope("")
    public BitcoinService bitcoinServiceNoCache(){
        System.out.println("Instantiation du bean BitcoinService sans cache par Spring");
        BitcoinService bitcoinService = new BitcoinService(webPageManager());
        bitcoinService.setForceRefresh(true);
        return bitcoinService;
    }

    @Bean
    public WebPageManager webPageManager(){
        System.out.println("Instanciation du WebPageManager par Spring");
        return new WebPageManager();
    }
    @Bean
    public ProduitManager produitManager() {
        System.out.println("Instanciation du ProduitManager par Spring");
        return new ProduitManager(bitcoinService(), webPageManager());
    }


}
