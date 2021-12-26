package org.example.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Example {
    public static void main(String[] args) throws Exception {
        Employee emp = new Employee(); /*.builder()
                .age(26)
                        .name("Adarsh").build();*/
        emp.setAge(26);
        emp.setName("Adarsh");
        emp.setMarks(new int[]{90,95});
        emp.setAddress(new Address("mysore", 570019));
        emp.setAccounts(new BankAccount[]{new BankAccount("Axis",123),new BankAccount("hdfc",456)});
        System.out.println("printing object " + emp);

        Employee[] emps = new Employee[]{emp,emp};

        ObjectMapper mapper = new ObjectMapper();
        String jsonString =  mapper.writeValueAsString(emp);
        String prettyJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);

        String jsonArrayString =  mapper.writeValueAsString(emps);
        String pretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emps);



        System.out.println("json string " + jsonString);

        System.out.println("pretty json string " + prettyJsonString);

        System.out.println("json array string " + jsonArrayString);

        System.out.println("pretty json array string " + pretty);








    }
}
