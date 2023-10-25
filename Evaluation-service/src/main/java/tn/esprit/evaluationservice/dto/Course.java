package tn.esprit.evaluationservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {
    long idCourse;
    String title;
    String description;
    long duration;
    String file;
    long calendarId;
}
