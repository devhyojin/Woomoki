package com.example.ssafypjt2.service;

import com.example.ssafypjt2.dao.NotificationDao;
import com.example.ssafypjt2.dto.NotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationDao dao;

    @Override
    public List<NotificationDto> notificationRequestList(int userId) {
        return dao.notificationList(userId);
    }
}
