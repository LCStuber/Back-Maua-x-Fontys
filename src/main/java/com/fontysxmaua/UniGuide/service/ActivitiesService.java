package com.fontysxmaua.UniGuide.service;

import com.fontysxmaua.UniGuide.mapper.ActivityMapper;
import com.fontysxmaua.UniGuide.model.entity.Activity;
import com.fontysxmaua.UniGuide.model.request.ActivityRequest;
import com.fontysxmaua.UniGuide.model.response.ActivityResponse;
import com.fontysxmaua.UniGuide.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivitiesService {

    private final ActivityRepository activityRepository;

    private final ActivityMapper activityMapper;

    public List<ActivityResponse> getAllActivities() {
        return ((List<Activity>) activityRepository.findAll())
                .stream()
                .map(activityMapper::toResponse)
                .toList();
    }

    public ActivityResponse addActivity(ActivityRequest request) {
        final var activity = activityMapper.toEntity(request);
        final var savedActivity = activityRepository.save(activity);

        return activityMapper.toResponse(savedActivity);
    }

    public void deleteActivity(String id) {
        activityRepository.deleteById(id);
    }
}
