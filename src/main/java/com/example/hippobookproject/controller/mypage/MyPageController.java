package com.example.hippobookproject.controller.mypage;

import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.service.mypage.MypageService;
import com.example.hippobookproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final UserService userService;
    private final MypageService mypageService;

    @GetMapping("/int")
    public String myPageInt(Model model/*@SessionAttribute("userId") Long userId*/){
        Long userId = 1L;
        IntProfileDto profileDto = mypageService.findProfile(userId);
        model.addAttribute("profileDto", profileDto);
        log.info("profileDto={}",profileDto);

        IntBoardDto intBoardDto = mypageService.findIntBoardText(userId);
        model.addAttribute("intBoardDto", intBoardDto);


        List<BookContainerDto> bookContainerList  = mypageService.findBookContainer(userId);
        model.addAttribute("bookContainerList", bookContainerList);
        return "mypage/myPageInt";
    }

    @PostMapping("/int")
    public String myPageInt(IntBoardDto intBoardDto){
        intBoardDto.setUserId(1L);
        log.info("IntBoardDto = {}", intBoardDto);
        mypageService.registerIntBoardText(intBoardDto);
        return "redirect:/mypage/int";
    }



    @GetMapping("/book/container")
    public String bookContainer(Model model){
        Long userId = 1L;
        List<BookContainerDto> bookContainerList  = mypageService.findBookContainer(userId);
        model.addAttribute("bookContainerList", bookContainerList);

        IntProfileDto profileDto = mypageService.findProfile(userId);
        model.addAttribute("profileDto", profileDto);


        log.info("bookContainerList={}",bookContainerList);
        return "mypage/myPageBookContainer";
    }






    @GetMapping("/book/write-content")
    public String bookWriteContent() {
        return "mypage/myWriteContent";
    }

    @GetMapping("/sticker")
    public String myPageSticker(){
        return "mypage/myPageInt_stiker";
    }

    @GetMapping("/manage")
    public String myPageManage(){
        return "mypage/myPageInt_manage";
    }

    @GetMapping("/modify")
    public String myPageModify(){
        return "mypage/myPageInt_modify";
    }

    @GetMapping("/secession")
    public String myPageSecession(){
        return "mypage/myPageInt_secession";
    }
}
