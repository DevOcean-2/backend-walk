package com.devocean.Balbalm.dummy.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceResponseDto {
	private String name;
	private String category;
	private List<String> pictures;
	private int distance;
	private String address;
}
