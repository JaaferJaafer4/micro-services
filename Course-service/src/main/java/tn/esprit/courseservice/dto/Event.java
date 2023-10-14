package tn.esprit.courseservice.dto;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    long eventId;
    String title;
    String description;
    Date startDate;
    Date endDate;
    long organizer;
    Set<Long> participants;
}
