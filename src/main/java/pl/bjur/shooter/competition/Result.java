package pl.bjur.shooter.competition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdEntity;
import pl.bjur.shooter.user.User;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result extends IdEntity {

    @NotBlank
    private User user;

    @NotNull
    @OneToOne
    private Competition competition;

    @NotNull
    @OneToOne
    private CompetitionCategory competitionCategory;

    @NotNull
    private BigDecimal score;

    private Integer centerHits;

    private String notes;

    private boolean outsideClasification;

    private boolean disqualified;
}
