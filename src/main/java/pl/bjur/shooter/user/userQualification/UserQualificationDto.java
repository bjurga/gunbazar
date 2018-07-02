package pl.bjur.shooter.user.userQualification;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdDto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserQualificationDto extends IdDto {

    @NotBlank
    private String name;

    private String qualificationNumber;

    private LocalDateTime validSince;

    private LocalDateTime validTo;

    @Builder
    public UserQualificationDto(Long id, @NotBlank String name, String qualificationNumber, LocalDateTime validSince, LocalDateTime validTo) {
        super(id);
        this.name = name;
        this.qualificationNumber = qualificationNumber;
        this.validSince = validSince;
        this.validTo = validTo;
    }
}
