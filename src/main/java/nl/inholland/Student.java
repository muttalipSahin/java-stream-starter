package nl.inholland;

import lombok.*;
import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private LocalDate birthdate;
    private Double grade;

    public Integer getAge() {
        if (birthdate != null) {
            return Period.between(birthdate, LocalDate.now()).getYears();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Student {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", grade=" + grade +
                '}';
    }
}

