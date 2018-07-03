package pl.bjur.shooter.competition.category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdDto;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto extends IdDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Builder
    public CategoryDto(Long id, @NotBlank String name, @NotBlank String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
