package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    public InitializationService getInitializationService() {
        return initializationService;
    }

    @PostConstruct
    public void init() {
        try {
            initializationService.initProjects();
        } catch (RuntimeException re) {
            logger.error("Error during initialization", re);
        }
    }
}
