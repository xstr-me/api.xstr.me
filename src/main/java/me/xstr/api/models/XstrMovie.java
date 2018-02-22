package me.xstr.api.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
public class XstrMovie {
	
    private long id;
    private String title;
    private String name;

}
