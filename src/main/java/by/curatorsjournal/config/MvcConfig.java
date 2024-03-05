package by.curatorsjournal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* Класс MVC конфигурации приложения
*
* @author V.A.Nichyporuk
*/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //Для страниц, которые никак не обрабатываются сервером, а просто возвращают страницу, маппинг можно настроить в конфигурации
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login1").setViewName("login1");
       //  registry.addViewController("/adminMain").setViewName("adminMain");
    }
}
