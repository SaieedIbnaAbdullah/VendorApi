package thinkConstructive.com.example.thinkConstructive.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thinkConstructive.com.example.thinkConstructive.demo.entity.VendorEntity;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Long> {
    Optional<VendorEntity> findVendorById(@Param("id") Long id);
}
