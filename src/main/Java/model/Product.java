package model;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Product {

    private static int counter;

    @Setter(AccessLevel.NONE)
    private int id;

    @NotEmpty(message = "Name should not be empty.")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30.")
    private String name;

    @Min(value = 0, message = "Cost should be greater than 0.")
    private double cost;

    public void setId() {
        id = ++counter;
    }
}
