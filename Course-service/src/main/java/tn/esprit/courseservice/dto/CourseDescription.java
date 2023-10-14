package tn.esprit.courseservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDescription {
    Date startDate;
    Date endDate;
    String organiser_name;
    String organiser_email;
    List<String> participants;
    String description;
    String title;
}
