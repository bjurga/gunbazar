package pl.bjur.shooter.tournament.competition.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdEntity;
import pl.bjur.shooter.tournament.Tournament;
import pl.bjur.shooter.tournament.competition.Competition;
import pl.bjur.shooter.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

import static pl.bjur.shooter.commons.Constants.RESULT_NOTE_MAX_CHARS;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result extends IdEntity {

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Tournament tournament;

    @NotNull
    @ManyToOne
    private Competition competition;

    @NotNull
    private BigDecimal score;

    private Integer centerHits;

    @Size(max = RESULT_NOTE_MAX_CHARS)
    private String notes;

    private boolean outsideClassification;

    private boolean disqualified;
}
