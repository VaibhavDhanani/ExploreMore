package com.exploremore;

import com.exploremore.dao.PackageRepository;
import com.exploremore.dao.UserRepository;
import com.exploremore.entites.Package;
import com.exploremore.entites.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExploreMoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ExploreMoreApplication.class, args);

    }

}
