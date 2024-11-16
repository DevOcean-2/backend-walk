package com.devocean.Balbalm.dummy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devocean.Balbalm.calendar.dto.WalkingDayDto;
import com.devocean.Balbalm.calendar.dto.resp.CalendarResponseDto;
import com.devocean.Balbalm.dummy.dto.DogInfoResponseDto;
import com.devocean.Balbalm.dummy.dto.PlaceResponseDto;
import com.devocean.Balbalm.dummy.dto.WalkRankingResponseDto;
import com.devocean.Balbalm.global.exception.CommonResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/dummy")
@RequiredArgsConstructor
public class DummyController {

	@GetMapping("/calendar")
	public CommonResponse<CalendarResponseDto> getCalendar(
		@RequestParam int year,
		@RequestParam int month) {
		List<WalkingDayDto> walkingDays = new ArrayList<>();
		for (int i = 1; i <= 31; i++) {
			walkingDays.add(new WalkingDayDto(i, i % 2 == 0));
		}

		CalendarResponseDto calendarResponse = new CalendarResponseDto(
			2024,
			12,
			walkingDays,
			0,
			5
		);

		return new CommonResponse<>(calendarResponse);
	}

	@GetMapping("/info")
	public CommonResponse<DogInfoResponseDto> getDogInfo() {
		DogInfoResponseDto dogInfoResponse = new DogInfoResponseDto(
			"최고강쥐",
			1,
			100,
			1
		);

		return new CommonResponse<>(dogInfoResponse);
	}

	@GetMapping("/walk-ranking")
	public CommonResponse<WalkRankingResponseDto> getWalkRanking() {
		List<WalkRankingResponseDto.DogInfo> dogList = new ArrayList<>();
		dogList.add(new WalkRankingResponseDto.DogInfo("https://balm-bucket.s3.ap-northeast-2.amazonaws.com/images/karina.png", "카리나", 500));
		dogList.add(new WalkRankingResponseDto.DogInfo("https://balm-bucket.s3.ap-northeast-2.amazonaws.com/images/winter.png", "윈터", 300));
		dogList.add(new WalkRankingResponseDto.DogInfo("https://balm-bucket.s3.ap-northeast-2.amazonaws.com/images/ex-dog.jpg", "내강아지최고", 100));

		WalkRankingResponseDto walkRankingResponse = new WalkRankingResponseDto(dogList);

		return new CommonResponse<>(walkRankingResponse);
	}

	@GetMapping("/place-recommend")
	public CommonResponse<List<PlaceResponseDto>> getPlaceRecommand() {
		List<PlaceResponseDto> placeList = new ArrayList<>();
		List<String> pictures = new ArrayList<>();
		pictures.add("https://balm-bucket.s3.ap-northeast-2.amazonaws.com/images/place/image.png");
		pictures.add("https://balm-bucket.s3.ap-northeast-2.amazonaws.com/images/place/image.png");
		pictures.add("https://balm-bucket.s3.ap-northeast-2.amazonaws.com/images/place/image.png");

		placeList.add(new PlaceResponseDto("모노톤베이크하우스", "카페, 디저트", pictures, 29, "경기 성남시 분당구 대왕판교로 103"));
		placeList.add(new PlaceResponseDto("모노톤베이크하우스", "카페, 디저트", pictures, 29, "경기 성남시 분당구 대왕판교로 103"));

		return new CommonResponse<>(placeList);
	}
}