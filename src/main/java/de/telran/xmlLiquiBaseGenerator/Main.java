package de.telran.xmlLiquiBaseGenerator;

import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        generate("liqu1.txt");
        generate("liqu2.txt");
        generate("liqu3.txt");
        generate("liqu4.txt");
        System.out.println("Генерация закончена!");
    }
    public static void generate(String writeFile) {
        Faker faker = new Faker();
        String readPath ="C:\\JAVA\\Lesson2PRO\\src\\main\\java\\de\\telran\\xmlLiquiBaseGenerator\\inputData\\";
        String writePath = "C:\\JAVA\\Lesson2PRO\\src\\main\\java\\de\\telran\\xmlLiquiBaseGenerator\\";

        //String writeFile = "liqu1.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(readPath+"input.txt"));
             FileWriter writer = new FileWriter(writePath+writeFile)) {
            String line;

            int count=0;
            //UUID uuid = UUID.randomUUID();
            String value;
            String nametable = "";
            while ((line = reader.readLine()) != null) {
                //System.out.println(line); // Выводим прочитанную строку
                //line.split(" ");
                if (line.startsWith("Table: ")){
                    nametable = line.split(" ")[1];
                    if (count!=0) {
                        writer.write("    </insert>\n");
                        writer.write("</changeSet>\n");
                        writer.write("\n");
                    }

                    writer.write("<changeSet author=\"o.harbuz\" id=\"insert test data into " + nametable +
                                " table\">\n");
                    writer.write("    <insert tableName=\"" + nametable + "\">\n");
                    count++;
                } else if (!(line.startsWith("//") || line.equals(""))) {
                    value =" ";
                    if (line.equals("id")) value = UUID.randomUUID().toString().replace("-","");
                    //if (nametable.equals("vehicle") && line.equals("name")){}
                    if (nametable.equals("employee") && line.equals("first_name")) value = faker.name().firstName();
                    if (nametable.equals("employee") && line.equals("last_name")) value = faker.name().lastName();

                    if (nametable.equals("employee_info") && line.equals("address")) value = faker.address().fullAddress();
                    if (nametable.equals("employee_info") && line.equals("phone")) value = faker.phoneNumber().phoneNumber();
                    if (nametable.equals("employee_info") && line.equals("login")) value = faker.name().username();
                    if (nametable.equals("employee_info") && line.equals("password")) value = faker.internet().password(6,10);

                    if (nametable.equals("task") && line.equals("address_from")) value = faker.address().fullAddress();
                    if (nametable.equals("task") && line.equals("address_to")) value = faker.address().fullAddress();

                    if (nametable.equals("company") && line.equals("company_name")) value = faker.company().name();
                    if (nametable.equals("company") && line.equals("contact_first_name")) value = faker.name().firstName();
                    if (nametable.equals("company") && line.equals("contact_last_name")) value = faker.name().lastName();
                    if (nametable.equals("company") && line.equals("email")) value = faker.name().lastName().toLowerCase()+"@gmail.com";
                    if (nametable.equals("company") && line.equals("address")) value = faker.address().fullAddress();
                    if (nametable.equals("company") && line.equals("phone")) value = faker.phoneNumber().phoneNumber();

                    if (line.equals("created_at")) value = LocalDate.now().toString();

                    if (line.equals("id")) {
                           writer.write("        <column name=\"" + line + "\" valueComputed=\"UNHEX('"+ value +"')\"/>\n");
                    } else writer.write("        <column name=\"" + line + "\" value=\""+ value +"\"/>\n");
                }

            }

            //writer.write(average + "");
            //Last Add
            writer.write("    </insert>\n");
            writer.write("</changeSet>\n");
            writer.write("\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


//UUID: 123e4567-e89b-12d3-a456-426655440000
//faker.internet().emailAddress()
//faker.internet().password()
//faker.name().username()
