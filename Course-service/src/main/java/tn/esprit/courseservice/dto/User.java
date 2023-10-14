package tn.esprit.courseservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    Long id;
    String username;
    String email;
    String password;
    LocalDate birthDate;
    String role;
}
