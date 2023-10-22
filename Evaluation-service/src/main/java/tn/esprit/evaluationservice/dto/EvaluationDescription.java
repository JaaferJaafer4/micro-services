package tn.esprit.evaluationservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EvaluationDescription {
    String title;
    String description;
    long duration;
    String criteres;
    Date dateEvaluation ;
    String resultat;
}
