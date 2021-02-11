package com.example.ssafypjt2.service;

import com.example.ssafypjt2.dto.NotificationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    public List<NotificationDto> notificationList (int userId);
    public int notificationConfirm (int notificationId);
}
