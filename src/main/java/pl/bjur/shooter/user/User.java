package pl.bjur.shooter.user;

import lombok.*;
import pl.bjur.shooter.commons.EntityWithId;

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
public class User extends EntityWithId {

    @Column(unique = true)
    @NotBlank
    private String displayName;

    @Email
    @Column(unique = true)
    @NotBlank
    private String email;

    @NotNull
    private String password;
}
