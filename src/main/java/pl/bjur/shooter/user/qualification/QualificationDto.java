package pl.bjur.shooter.user.qualification;

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
public class QualificationDto extends IdDto {

    @NotBlank
    private String name;

    private String qualificationNumber;

    private LocalDateTime validFrom;

    private LocalDateTime validTo;

    @Builder
    public QualificationDto(Long id, @NotBlank String name, String qualificationNumber, LocalDateTime validFrom, LocalDateTime validTo) {
        super(id);
        this.name = name;
        this.qualificationNumber = qualificationNumber;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
}
