package com.fontysxmaua.UniGuide.mapper;

import com.fontysxmaua.UniGuide.model.entity.Activity;
import com.fontysxmaua.UniGuide.model.request.ActivityRequest;
import com.fontysxmaua.UniGuide.model.response.ActivityResponse;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {
    public ActivityResponse toResponse(Activity activity) {
        return new ActivityResponse(
                activity.getId(),
                activity.getName(),
                activity.getRoom(),
                activity.getTime()
        );
    }

    public Activity toEntity(ActivityRequest request) {
        return Activity.builder()
                .name(request.getName())
                .room(request.getRoom())
                .time(request.getTime())
                .build();
    }
}