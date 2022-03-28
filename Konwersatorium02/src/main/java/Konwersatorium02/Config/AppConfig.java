package Konwersatorium02.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // aplikacje SpringBoot mozna konfigurować w pliku application.properties i AppConfig
    // bean - w javie, żyjące w aplikacji jednostki, obiekty, których zadaniem jest działać na rzecz całej aplikacji

    // klase pochodzącą z zewnątrz można przerobić na bean'a
    // @Bean używamy z poziomu @Configuration
    @Bean
    public Item item(){ // new Item item bean
        return new Item(); // lub jeśli Item jest interfacem, to dostarczamy jakąs implementacje
    }
    @Bean
    public Store store() { // new Store store bean
        return new Store();
        // 2 sposób na wywołanie Beana
        // new StoreImplementation(this.item());
    }
}

