package org.example.serialization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private int age;
    private int[] marks;
    private Address address;
    private BankAccount[] accounts;
    private boolean isAdmin;
}
