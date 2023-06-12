package IR.org.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages={"IR.org.*"})
public class IRCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(IRCoreApplication.class,args);
    }
}
