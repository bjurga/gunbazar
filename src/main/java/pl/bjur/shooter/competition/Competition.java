package pl.bjur.shooter.competition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.club.Club;
import pl.bjur.shooter.commons.IdEntity;
import pl.bjur.shooter.competition.category.Category;
import pl.bjur.shooter.competition.result.Result;
import pl.bjur.shooter.shootingrange.ShootingRange;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//TODO: rename it to Tournament
public class Competition extends IdEntity {

    @NotBlank
    private String name;

    @NotNull
    @OneToOne
    private ShootingRange shootingRange;

    @NotNull
    @ManyToOne
    private Club owner;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    @NotNull
    private LocalDateTime onSiteRegistrationEnd;

    @NotNull
    private LocalDateTime onlineRegistrationEnd;

    private String description;

    @OneToMany
    private Set<Result> results;

    @OneToMany
    private Set<Category> availableCategories;

}
