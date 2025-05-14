package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.Notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long>{

}
