package ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    @Transactional
    public void initProjects() {
        // L'annotation @Transactional lance une transaction au debut de l'execution de la fonction et cela permet que
        // si une etape dans la creation des donnees initiales echoue, aucune donnee n'est ecrite.

        enterprise1 = enterpriseProjectService.newEnterprise("enterprise1", "description1", "contactName1", "mail1@mail.com");
        enterprise2 = enterpriseProjectService.newEnterprise("enterprise2", "description2", "contactName2", "mail2@mail.com");

        project1E1 = enterpriseProjectService.newProject("project1E1", "description1E1", enterprise1);
        project1E2 = enterpriseProjectService.newProject("project1E2", "description1E2", enterprise2);
        project2E1 = enterpriseProjectService.newProject("project2E1", "description2E1", enterprise1);
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }
}
