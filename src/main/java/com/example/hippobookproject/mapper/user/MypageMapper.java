package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Mapper
public interface MypageMapper {
    Optional<IntProfileDto> selectProfile(Long userId);

    void insertIntBoardText(IntBoardDto intBoardDto);

    Optional<IntBoardDto> selectIntBoardText(Long userId);


    void updateIntBoardText(IntBoardDto intBoardDto);

    List<BookContainerDto> selectRecentBook(Long userId);

    List<MyContentDto> selectMyContent(Long userId);

    Long selectReviewCount(Long userId);

    Long selectPostCount(Long userId);

    Optional<IntProfileDto> selectProfilePhoto(Long userId);

    void insertSticker(StickerDto stickerDto);

    Long selectSticker(Long userId);

}
