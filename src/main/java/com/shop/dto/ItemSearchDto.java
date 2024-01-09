package com.shop.dto;

import com.shop.constant.ItemSellStatus;
import lombok.*;

@Getter @Setter
public class ItemSearchDto {

    private String searchDateType; // 현재시간과 상품등록일을 비교하여 조회

    private ItemSellStatus searchSellStatus; // 판매 상태 기준

    private String searchBy; // 상품 조회시 유형 itemNm:상품명, createdBy:상품 등록자 아이디

    private String searchQuery = ""; // 조회할 검색어를 저장할 변수
}
