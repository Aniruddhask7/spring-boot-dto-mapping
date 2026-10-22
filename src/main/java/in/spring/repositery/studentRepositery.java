package in.spring.repositery;

import in.spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface studentRepositery extends JpaRepository<Student ,  Long> {




}
