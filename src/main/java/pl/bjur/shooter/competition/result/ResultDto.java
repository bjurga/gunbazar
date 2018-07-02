package pl.bjur.shooter.competition.result;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdDto;
import pl.bjur.shooter.competition.CompetitionDto;
import pl.bjur.shooter.competition.category.CategoryDto;
import pl.bjur.shooter.user.UserDto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ResultDto extends IdDto {

    @NotNull
    @ManyToOne
    private UserDto user;

    @NotNull
    @ManyToOne
    private CompetitionDto competition;

    @NotNull
    @ManyToOne
    private CategoryDto category;

    @NotNull
    private BigDecimal score;

    private Integer centerHits;

    private String notes;

    private boolean outsideClassification;

    private boolean disqualified;

    @Builder
    public ResultDto(Long id, @NotNull UserDto user, @NotNull CompetitionDto competition,
                     @NotNull CategoryDto category, @NotNull BigDecimal score, Integer centerHits, String notes,
                     boolean outsideClassification, boolean disqualified) {
        super(id);
        this.user = user;
        this.competition = competition;
        this.category = category;
        this.score = score;
        this.centerHits = centerHits;
        this.notes = notes;
        this.outsideClassification = outsideClassification;
        this.disqualified = disqualified;
    }
}
