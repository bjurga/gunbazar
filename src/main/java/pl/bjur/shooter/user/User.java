package pl.bjur.shooter.user;

import lombok.*;
import pl.bjur.shooter.commons.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends IdEntity {

    @Column(unique = true)
    @NotBlank
    private String displayName;

    @Email
    @Column(unique = true)
    @NotBlank
    private String email;

    @NotNull
    private String password;

//    @OneToMany
//    private Set<UserQualification> qualifications;
}
