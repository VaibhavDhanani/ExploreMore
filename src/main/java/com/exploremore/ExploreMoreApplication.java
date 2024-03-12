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
//        PackageRepository pacrepo = context.getBean(PackageRepository.class);
//
//        Package p = new Package();
//        p.setPrice(100);
//        p.setDuration("10");
//        p.setAvailability(10);
//        p.setName("test");
//        pacrepo.save(p);



//        UserRepository user = context.getBean(UserRepository.class);
//
//        User u = new User();
//        u.setEmail("rich@gmail.com");
//        u.setFirstName("Rich");
//        u.setLastName("Amrutiya");
//        u.setUserName("Rich-Amrutiya");
//        u.setPhoneNo("6353249404");
//        u.setPassword("Rich101b");
//        user.save(u);


=======
    }

}
