package ru.ssu.Vasilenko;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;


enum Gender {
    Male,
    Female;
}

@EqualsAndHashCode
@Setter
@Getter
@ToString
class Account {
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
}