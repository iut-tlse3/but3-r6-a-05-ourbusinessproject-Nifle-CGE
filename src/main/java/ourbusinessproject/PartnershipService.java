package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PartnershipService {

    @PersistenceContext
    private EntityManager entityManager;

    public Partnership newPartnership(Project project, Enterprise partnerEnterprise) {
        Partnership partnership = new Partnership();
        partnership.setCreationDate(new Date());
        partnership.setProject(project);
        partnership.setEnterprise(partnerEnterprise);
        entityManager.persist(partnership);
        entityManager.flush();
        return partnership;
    }

    public Partnership findPartnershipById(Long id) {
        return entityManager.find(Partnership.class, id);
    }

    public void remove(Partnership partnership) {
        entityManager.remove(partnership);
    }
}
