package pl.bjur.strzelec.dupa.commons;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class HasEmailAndPassword extends EntityWithId {

    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}
