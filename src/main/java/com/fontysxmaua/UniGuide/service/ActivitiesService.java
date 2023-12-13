package com.fontysxmaua.UniGuide.service;

import com.fontysxmaua.UniGuide.mapper.ActivityMapper;
import com.fontysxmaua.UniGuide.model.entity.Activity;
import com.fontysxmaua.UniGuide.model.request.ActivityRequest;
import com.fontysxmaua.UniGuide.model.response.ActivityResponse;
import com.fontysxmaua.UniGuide.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ActivitiesService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;

    public List<ActivityResponse> getAllActivities() {
        return ((List<Activity>) activityRepository.findAll())
                .stream()
                .sorted(Comparator.comparing(Activity::getStartDate))
                .map(activityMapper::toResponse)
                .toList();
    }

public List<ActivityResponse> getAllActivitiesByEmail(String email) {
    List<ActivityResponse> activities = getAllActivities();

    // Filter activities based on the condition
    List<ActivityResponse> filteredActivities = activities.stream()
            .filter(activity -> {
                Set<String> subscribed = activity.getSubscribed();
                return subscribed != null && subscribed.contains(email);
            })
            .toList();

    System.out.println("batata2");
    System.out.println(filteredActivities);
    return filteredActivities;
}

    public ActivityResponse getActivityById(String id) {
        return activityMapper.toResponse(activityRepository.findById(id).orElseThrow());
    }

    public ActivityResponse addActivity(ActivityRequest request) {
        final var activity = activityMapper.toEntity(request);
        final var savedActivity = activityRepository.save(activity);

        return activityMapper.toResponse(savedActivity);
    }

    public ActivityResponse addPersonToActivity(String id, String personEmail) {
        final var activity = activityRepository.findById(id).orElseThrow();
        activity.addAttending(personEmail);
        final var savedActivity = activityRepository.save(activity);

        return activityMapper.toResponse(savedActivity);
    }

    public ActivityResponse subscribePersonToActivity(String id, String personEmail) {
        final var activity = activityRepository.findById(id).orElseThrow();
        activity.addSubscribed(personEmail);
        final var savedActivity = activityRepository.save(activity);

        return activityMapper.toResponse(savedActivity);
    }

    public ActivityResponse unsubscribePersonFromActivity(String id, String personEmail){
        final var activity = activityRepository.findById(id).orElseThrow();
        activity.removeSubscribed(personEmail);
        final var savedActivity = activityRepository.save(activity);

        return activityMapper.toResponse(savedActivity);
    }

    public void deleteActivity(String id) {
        activityRepository.deleteById(id);
    }
}
