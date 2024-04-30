package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository <User,Long> {




}
