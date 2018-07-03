package pl.bjur.shooter.tournament;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.club.ClubDto;
import pl.bjur.shooter.commons.IdDto;
import pl.bjur.shooter.shootingrange.ShootingRangeDto;
import pl.bjur.shooter.tournament.competition.CompetitionDto;
import pl.bjur.shooter.tournament.competition.result.ResultDto;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TournamentDto extends IdDto {

    @NotBlank
    private String name;

    @NotNull
    private ShootingRangeDto shootingRange;

    @NotNull
    private ClubDto owner;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    @NotNull
    private LocalDateTime onSiteRegistrationEnd;

    @NotNull
    private LocalDateTime onlineRegistrationEnd;

    private String description;

    private Set<ResultDto> results;

    @OneToMany
    private Set<CompetitionDto> availableCategories;

    @Builder
    public TournamentDto(Long id, @NotBlank String name, @NotNull ShootingRangeDto shootingRange, @NotNull ClubDto owner,
                         @NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime,
                         @NotNull LocalDateTime onSiteRegistrationEnd, @NotNull LocalDateTime onlineRegistrationEnd,
                         String description, Set<ResultDto> results, Set<CompetitionDto> availableCategories) {
        super(id);
        this.name = name;
        this.shootingRange = shootingRange;
        this.owner = owner;
        this.startTime = startTime;
        this.endTime = endTime;
        this.onSiteRegistrationEnd = onSiteRegistrationEnd;
        this.onlineRegistrationEnd = onlineRegistrationEnd;
        this.description = description;
        this.results = results;
        this.availableCategories = availableCategories;
    }
}
