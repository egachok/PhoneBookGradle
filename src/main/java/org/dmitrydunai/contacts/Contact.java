package org.dmitrydunai.contacts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Contact{
    private String name;
    private Long id;
    private ContactType contactType;
    private String value;

    public Contact(String name, String value) {
        this.name = name;
        this.value = value;
    }
}