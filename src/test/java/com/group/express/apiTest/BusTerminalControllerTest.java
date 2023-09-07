package com.group.express.apiTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.express.controller.apiController;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusTerminalControllerTest {

    @InjectMocks
    private apiController apiController;

    @Mock
    private RestTemplate restTemplate;
    private Map<String, Object> fakeRegionMap; // 필드로 선언

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Mock 초기화 테스트코드 삭제하던가 나중에 수정해야함.

        fakeRegionMap = new HashMap<>();
        fakeRegionMap.put("0", createRegionMap("서울", new ArrayList<>()));
        fakeRegionMap.put("1", createRegionMap("인천/경기", new ArrayList<>()));

        // restTemplate.exchange 메서드 호출 시 응답 데이터 설정
        when(restTemplate.exchange(any(URI.class), eq(org.springframework.http.HttpMethod.GET), any(HttpEntity.class), eq(String.class)))
                .thenReturn(new ResponseEntity<>(asJsonString(fakeRegionMap), HttpStatus.OK));
    }

    @Test
    public void testGetBusTerminalList() throws Exception {
        // GET 요청 수행
        ResponseEntity<Map<String, List<Map<String, Object>>>> responseEntity = apiController.getBusTerminalList();

        // 응답 검증
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo(fakeRegionMap);
    }

    // 지역별 터미널 정보를 가짜 데이터로 생성하는 메서드
    private Map<String, Object> createRegionMap(String regionName, List<Map<String, Object>> terminals) {
        Map<String, Object> regionMap = new HashMap<>();
        regionMap.put("regionName", regionName);
        regionMap.put("terminals", terminals);
        return regionMap;
    }

    // 객체를 JSON 문자열로 변환하는 메서드
    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



