package com.devocean.Balbalm.dummy.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalkRankingResponseDto {
	private List<DogInfo> dogList;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class DogInfo {
		private String photoPath;
		private String nickname;
		private int distance;
	}
}