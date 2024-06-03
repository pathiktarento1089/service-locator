package com.igot.service_locator.repository;

import com.igot.service_locator.entity.ServiceLocatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceLocatorRepository extends JpaRepository<ServiceLocatorEntity, String> {

    Optional<ServiceLocatorEntity> findById(String id);
    @Query("select s from ServiceLocatorEntity s where s.isActive = :isActive")
    List<ServiceLocatorEntity> findAll(boolean isActive);

    Optional<ServiceLocatorEntity> findByServiceCodeAndIsActiveTrue(String serviceCode);

    @Query("select s from ServiceLocatorEntity s where s.id = :id and s.isActive = :isActive")
    Optional<ServiceLocatorEntity> findById(@Param("id") String id,@Param("isActive") boolean isActive);

    List<ServiceLocatorEntity> findByUrl(String url);
    List<ServiceLocatorEntity> findByServiceName(String serviceName);
    List<ServiceLocatorEntity> findByOperationType(String operationType);
}