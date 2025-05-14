package com.toolshare.toolshare.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolshare.toolshare.Domain.Notifications;

public interface NotificationsRepository extends JpaRepository<Notifications, Long>{

}
