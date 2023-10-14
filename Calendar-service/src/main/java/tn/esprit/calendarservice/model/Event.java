package tn.esprit.calendarservice.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long eventId;
    @NotNull
    String title;
    String description;
    @NotNull
    Date startDate;
    @NotNull
    Date endDate;
    long organizer;
    @ElementCollection(fetch = FetchType.EAGER)
    Set<Long> participants;
}
