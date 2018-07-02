package pl.bjur.shooter.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdDto;
import pl.bjur.shooter.user.userQualification.UserQualificationDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends IdDto {

    @NotBlank
    private String displayName;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private String password;

    private Set<UserQualificationDto> qualifications;

    @Builder
    public UserDto(Long id, @NotBlank String displayName, @Email @NotBlank String email, @NotNull String password, Set<UserQualificationDto> qualifications) {
        super(id);
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.qualifications = qualifications;
    }
}
