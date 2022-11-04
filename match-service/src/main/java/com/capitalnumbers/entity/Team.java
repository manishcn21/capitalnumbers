package com.capitalnumbers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.capitalnumbers.Views;
import com.fasterxml.jackson.annotation.JsonView;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {	
	private Long id;
	private String name;
	
	public Team(String name) {
		this.name = name;
	}
}
