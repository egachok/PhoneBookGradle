package org.dmitrydunai.contacts;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Contact {
    private String name;
    private String phone;
}