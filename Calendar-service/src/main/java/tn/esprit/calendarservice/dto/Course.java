package tn.esprit.calendarservice.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {
    long idCourse;
    String title;
    String description;
    long duration;
    String file;
}
