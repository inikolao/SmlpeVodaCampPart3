package iniko.Voda;

import iniko.Voda.AppConfig.Session.SessionCleaner;
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


        //initialize.InitializeProductType(7);
       // initialize.InitializeProductCategory(11);
       // initialize.InitializeOrderCategory(11);
       // initialize.InitializeFileType(10);
      // initialize.InitializeFile(101);
       // initialize.InitializeProducts();
      //  initialize.InitializeUsers();
    }




}
