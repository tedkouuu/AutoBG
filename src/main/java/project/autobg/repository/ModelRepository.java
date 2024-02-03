package project.autobg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.autobg.model.entity.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
