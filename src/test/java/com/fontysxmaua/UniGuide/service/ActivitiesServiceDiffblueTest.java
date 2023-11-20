package com.fontysxmaua.UniGuide.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fontysxmaua.UniGuide.mapper.ActivityMapper;
import com.fontysxmaua.UniGuide.model.entity.Activity;
import com.fontysxmaua.UniGuide.model.request.ActivityRequest;
import com.fontysxmaua.UniGuide.model.response.ActivityResponse;
import com.fontysxmaua.UniGuide.repository.ActivityRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ActivitiesService.class})
@ExtendWith(SpringExtension.class)
class ActivitiesServiceDiffblueTest {
    @Autowired
    private ActivitiesService activitiesService;

    @MockBean
    private ActivityMapper activityMapper;

    @MockBean
    private ActivityRepository activityRepository;

    /**
     * Method under test: {@link ActivitiesService#getAllActivities()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllActivities() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class org.mockito.codegen.Iterable$MockitoMock$937609609 cannot be cast to class java.util.List (org.mockito.codegen.Iterable$MockitoMock$937609609 is in unnamed module of loader com.diffblue.cover.g.g @1415511c; java.util.List is in module java.base of loader 'bootstrap')
        //       at com.fontysxmaua.UniGuide.service.ActivitiesService.getAllActivities(ActivitiesService.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        // TODO: Populate arranged inputs
        List<ActivityResponse> actualAllActivities = this.activitiesService.getAllActivities();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link ActivitiesService#getActivityById(String)}
     */
    @Test
    void testGetActivityById() {
        Activity.ActivityBuilder builderResult = Activity.builder();
        Activity.ActivityBuilder descriptionResult = builderResult.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult = descriptionResult
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult = roomResult
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        Optional<Activity> ofResult = Optional.of(startDateResult.subscribed(new HashSet<>()).build());
        when(activityRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        HashSet<String> subscribed = new HashSet<>();
        ActivityResponse activityResponse = new ActivityResponse("42", true, startDate, endDate, "Name",
                "The characteristics of someone or something", "Room", 3, subscribed, new HashSet<>(), "Lector");

        when(activityMapper.toResponse(Mockito.<Activity>any())).thenReturn(activityResponse);
        ActivityResponse actualActivityById = activitiesService.getActivityById("42");
        verify(activityMapper).toResponse(Mockito.<Activity>any());
        verify(activityRepository).findById(Mockito.<String>any());
        assertSame(activityResponse, actualActivityById);
    }

    /**
     * Method under test: {@link ActivitiesService#addActivity(ActivityRequest)}
     */
    @Test
    void testAddActivity() {
        Activity.ActivityBuilder builderResult = Activity.builder();
        Activity.ActivityBuilder descriptionResult = builderResult.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult = descriptionResult
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult = roomResult
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(activityRepository.save(Mockito.<Activity>any()))
                .thenReturn(startDateResult.subscribed(new HashSet<>()).build());
        Activity.ActivityBuilder builderResult2 = Activity.builder();
        Activity.ActivityBuilder descriptionResult2 = builderResult2.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult2 = descriptionResult2
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult2 = roomResult2
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(activityMapper.toEntity(Mockito.<ActivityRequest>any()))
                .thenReturn(startDateResult2.subscribed(new HashSet<>()).build());
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        HashSet<String> subscribed = new HashSet<>();
        ActivityResponse activityResponse = new ActivityResponse("42", true, startDate, endDate, "Name",
                "The characteristics of someone or something", "Room", 3, subscribed, new HashSet<>(), "Lector");

        when(activityMapper.toResponse(Mockito.<Activity>any())).thenReturn(activityResponse);
        ActivityResponse actualAddActivityResult = activitiesService.addActivity(new ActivityRequest());
        verify(activityMapper).toEntity(Mockito.<ActivityRequest>any());
        verify(activityMapper).toResponse(Mockito.<Activity>any());
        verify(activityRepository).save(Mockito.<Activity>any());
        assertSame(activityResponse, actualAddActivityResult);
    }

    /**
     * Method under test: {@link ActivitiesService#addPersonToActivity(String, String)}
     */
    @Test
    void testAddPersonToActivity() {
        Activity.ActivityBuilder builderResult = Activity.builder();
        Activity.ActivityBuilder descriptionResult = builderResult.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult = descriptionResult
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult = roomResult
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(activityRepository.save(Mockito.<Activity>any()))
                .thenReturn(startDateResult.subscribed(new HashSet<>()).build());
        Activity.ActivityBuilder builderResult2 = Activity.builder();
        Activity.ActivityBuilder descriptionResult2 = builderResult2.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult2 = descriptionResult2
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult2 = roomResult2
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        Optional<Activity> ofResult = Optional.of(startDateResult2.subscribed(new HashSet<>()).build());
        when(activityRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        HashSet<String> subscribed = new HashSet<>();
        ActivityResponse activityResponse = new ActivityResponse("42", true, startDate, endDate, "Name",
                "The characteristics of someone or something", "Room", 3, subscribed, new HashSet<>(), "Lector");

        when(activityMapper.toResponse(Mockito.<Activity>any())).thenReturn(activityResponse);
        ActivityResponse actualAddPersonToActivityResult = activitiesService.addPersonToActivity("42",
                "jane.doe@example.org");
        verify(activityMapper).toResponse(Mockito.<Activity>any());
        verify(activityRepository).findById(Mockito.<String>any());
        verify(activityRepository).save(Mockito.<Activity>any());
        assertSame(activityResponse, actualAddPersonToActivityResult);
    }

    /**
     * Method under test: {@link ActivitiesService#subscribePersonToActivity(String, String)}
     */
    @Test
    void testSubscribePersonToActivity() {
        Activity.ActivityBuilder builderResult = Activity.builder();
        Activity.ActivityBuilder descriptionResult = builderResult.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult = descriptionResult
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult = roomResult
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(activityRepository.save(Mockito.<Activity>any()))
                .thenReturn(startDateResult.subscribed(new HashSet<>()).build());
        Activity.ActivityBuilder builderResult2 = Activity.builder();
        Activity.ActivityBuilder descriptionResult2 = builderResult2.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult2 = descriptionResult2
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult2 = roomResult2
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        Optional<Activity> ofResult = Optional.of(startDateResult2.subscribed(new HashSet<>()).build());
        when(activityRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        HashSet<String> subscribed = new HashSet<>();
        ActivityResponse activityResponse = new ActivityResponse("42", true, startDate, endDate, "Name",
                "The characteristics of someone or something", "Room", 3, subscribed, new HashSet<>(), "Lector");

        when(activityMapper.toResponse(Mockito.<Activity>any())).thenReturn(activityResponse);
        ActivityResponse actualSubscribePersonToActivityResult = activitiesService.subscribePersonToActivity("42",
                "jane.doe@example.org");
        verify(activityMapper).toResponse(Mockito.<Activity>any());
        verify(activityRepository).findById(Mockito.<String>any());
        verify(activityRepository).save(Mockito.<Activity>any());
        assertSame(activityResponse, actualSubscribePersonToActivityResult);
    }

    /**
     * Method under test: {@link ActivitiesService#unsubscribePersonFromActivity(String, String)}
     */
    @Test
    void testUnsubscribePersonFromActivity() {
        Activity.ActivityBuilder builderResult = Activity.builder();
        Activity.ActivityBuilder descriptionResult = builderResult.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult = descriptionResult
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult = roomResult
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(activityRepository.save(Mockito.<Activity>any()))
                .thenReturn(startDateResult.subscribed(new HashSet<>()).build());
        Activity.ActivityBuilder builderResult2 = Activity.builder();
        Activity.ActivityBuilder descriptionResult2 = builderResult2.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult2 = descriptionResult2
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult2 = roomResult2
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        Optional<Activity> ofResult = Optional.of(startDateResult2.subscribed(new HashSet<>()).build());
        when(activityRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        HashSet<String> subscribed = new HashSet<>();
        ActivityResponse activityResponse = new ActivityResponse("42", true, startDate, endDate, "Name",
                "The characteristics of someone or something", "Room", 3, subscribed, new HashSet<>(), "Lector");

        when(activityMapper.toResponse(Mockito.<Activity>any())).thenReturn(activityResponse);
        ActivityResponse actualUnsubscribePersonFromActivityResult = activitiesService.unsubscribePersonFromActivity("42",
                "jane.doe@example.org");
        verify(activityMapper).toResponse(Mockito.<Activity>any());
        verify(activityRepository).findById(Mockito.<String>any());
        verify(activityRepository).save(Mockito.<Activity>any());
        assertSame(activityResponse, actualUnsubscribePersonFromActivityResult);
    }

    /**
     * Method under test: {@link ActivitiesService#unsubscribePersonFromActivity(String, String)}
     */
    @Test
    void testUnsubscribePersonFromActivity2() {
        HashSet<String> subscribed = new HashSet<>();
        subscribed.add("foo");
        Activity.ActivityBuilder builderResult = Activity.builder();
        Activity.ActivityBuilder descriptionResult = builderResult.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult = descriptionResult
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Optional<Activity> ofResult = Optional.of(
                roomResult.startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                        .subscribed(subscribed)
                        .build());
        Activity.ActivityBuilder builderResult2 = Activity.builder();
        Activity.ActivityBuilder descriptionResult2 = builderResult2.attending(new HashSet<>())
                .capacity(3)
                .description("The characteristics of someone or something");
        Activity.ActivityBuilder roomResult2 = descriptionResult2
                .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .id("42")
                .lector("Lector")
                .name("Name")
                .room("Room");
        Activity.ActivityBuilder startDateResult = roomResult2
                .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(activityRepository.save(Mockito.<Activity>any()))
                .thenReturn(startDateResult.subscribed(new HashSet<>()).build());
        when(activityRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        HashSet<String> subscribed2 = new HashSet<>();
        ActivityResponse activityResponse = new ActivityResponse("42", true, startDate, endDate, "Name",
                "The characteristics of someone or something", "Room", 3, subscribed2, new HashSet<>(), "Lector");

        when(activityMapper.toResponse(Mockito.<Activity>any())).thenReturn(activityResponse);
        ActivityResponse actualUnsubscribePersonFromActivityResult = activitiesService.unsubscribePersonFromActivity("42",
                "jane.doe@example.org");
        verify(activityMapper).toResponse(Mockito.<Activity>any());
        verify(activityRepository).findById(Mockito.<String>any());
        verify(activityRepository).save(Mockito.<Activity>any());
        assertSame(activityResponse, actualUnsubscribePersonFromActivityResult);
    }

    /**
     * Method under test: {@link ActivitiesService#deleteActivity(String)}
     */
    @Test
    void testDeleteActivity() {
        doNothing().when(activityRepository).deleteById(Mockito.<String>any());
        activitiesService.deleteActivity("42");
        verify(activityRepository).deleteById(Mockito.<String>any());
    }
}

