package com.vega.springit;

import com.vega.springit.config.SpringitProperties;
import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
@ConfigurationPropertiesScan("com.vega.springit.config")
@EnableJpaAuditing
public class SpringitApplication
{

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);
    @Autowired
    private SpringitProperties springitProperties;
    @Autowired
    private ApplicationContext applicationContext;
    public static void main(String[] args)
    {
        SpringApplication.run(SpringitApplication.class, args);
        log.info("Hello from the LOGGER");
    }

    @Bean
    @Profile("dev")
    CommandLineRunner runner (LinkRepository linkRepository, CommentRepository commentRepository)
    {
        return args ->
        {
            Link link = new Link("Getting started with SpringBoot 2", "hhtps://thereaddanvega/spring-boot-2");
            linkRepository.save(link);

            Comment comment = new Comment("This Spring Boot 2 link is awesome!", link);
            commentRepository.save(comment);

            link.addComment(comment);

            log.info("We just inserted a link and comment");

           // Link firstLink = linkRepository.findByTitle("Getting started with SpringBoot 2");
           // log.info("the title is = "+firstLink.getTitle());
           // System.out.println(link.getComments());




            //log.info("Welcome Message="+springitProperties.getWelcomeMsg());
           // String[] beans=applicationContext.getBeanDefinitionNames();
            //Arrays.stream(beans).forEach(bean -> System.out.println(bean));
        };
    }

}
