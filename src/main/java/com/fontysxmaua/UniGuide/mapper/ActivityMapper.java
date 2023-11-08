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
                activity.getIsMandatory(),
                activity.getStartDate(),
                activity.getEndDate(),
                activity.getName(),
                activity.getDescription(),
                activity.getRoom(),
                activity.getCapacity(),
                activity.getSubscribed(),
                activity.getAttending()
        );
    }

    public Activity toEntity(ActivityRequest request) {
        return Activity.builder()
                .isMandatory(request.getIsMandatory())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .name(request.getName())
                .description(request.getDescription())
                .room(request.getRoom())
                .capacity(request.getCapacity())
                .build();
    }
}