package com.noelnp.sportsbooklite.modules.user.domain.repository;

import com.noelnp.sportsbooklite.modules.user.infra.jpa.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);
}
