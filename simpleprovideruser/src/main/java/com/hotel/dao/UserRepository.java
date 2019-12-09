package com.hotel.dao;

import com.hotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JAP Service
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
