package com.devocean.Balbalm.dummy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogInfoResponseDto {
	private String dogName;
	private int dogBreed;
	private int maxWalk;
	private int maxRank;
}