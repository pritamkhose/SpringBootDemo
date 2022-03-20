package com.pritam.demo.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pets {
	@Id
	public String _id;

	@NotNull
	public String name;
	@NotNull
	public String species;
	@NotNull
	public String breed;

}
