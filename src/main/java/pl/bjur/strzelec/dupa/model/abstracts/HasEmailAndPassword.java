package pl.bjur.strzelec.dupa.model.abstracts;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public abstract class HasEmailAndPassword extends EntityWithId {

    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}
