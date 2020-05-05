package com.ipiecoles.java.java240;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


@SpringBootApplication
//équivalent à @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Value("${bitcoinService.forceRefresh}")
    private  Boolean forceRfresh;


    @Bean
    @Scope("singleton")//équivalent à ne rien mettre ou mettre @Scope("")
    public BitcoinService bitcoinServiceNoCache(){
        System.out.println("Instantiation du bean BitcoinService sans cache par Spring");
        BitcoinService bitcoinService = new BitcoinService(/*webPageManager()*/);
        bitcoinService.setForceRefresh(true);
        return bitcoinService;
    }

}
