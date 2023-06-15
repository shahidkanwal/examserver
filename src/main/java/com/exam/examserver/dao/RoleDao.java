package com.exam.examserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examserver.models.Role;

public interface RoleDao extends JpaRepository<Role, Long>{

}
