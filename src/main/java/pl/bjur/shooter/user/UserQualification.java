package pl.bjur.shooter.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserQualification extends IdEntity {

    @NotBlank
    private String name;

    private String qualificationNumber;

    private LocalDateTime validSince;

    private LocalDateTime validTo;
}
