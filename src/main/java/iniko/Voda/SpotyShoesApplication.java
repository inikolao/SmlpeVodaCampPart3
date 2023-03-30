package iniko.Voda;

import iniko.Voda.Services.Initializers.BasicInitialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpotyShoesApplication {

    @Autowired
    BasicInitialize initialize;
    public static void main(String[] args) {
        SpringApplication.run(SpotyShoesApplication.class, args);

    }

    @Bean
    public void setUp() {
        //BasicInitialize initialize=new BasicInitialize(20,15,15,30,40);
        initialize.InitializeProductType(200);
        initialize.InitializeProductCategory(15);
        initialize.InitializeOrderCategory(15);
        initialize.InitializeFileType(30);
        initialize.InitializeFile(15);
        initialize.InitializeProducts();
        initialize.InitializeUsers();
    }

}
