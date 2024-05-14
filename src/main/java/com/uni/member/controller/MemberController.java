package com.uni.member.controller;

import com.uni.member.dto.MemberDTO;
import com.uni.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/save")
    public String saveForm() {
        return "/members/save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);

        return "index";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        MemberDTO loginResult = memberService.login(memberDTO);
        System.out.println(loginResult);
        if(loginResult != null) {
            session.setAttribute("loginId", loginResult.getMemberId());
            session.setAttribute("loginInfo", loginResult);
            return "main";
        } else {
            //model.addAttribute("error", "로그인 실패");
            System.out.println("Login Fail");
            return "main";
        }
    }

    @PostMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
    @GetMapping("/member/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "members/list";
    }

    @GetMapping("/member/{memberId}")
    public String findById(@PathVariable String memberId, Model model) {
        MemberDTO memberDTO = memberService.findById(memberId);
        model.addAttribute("member", memberDTO);
        return "/members/detail";
    }

    @GetMapping("/member/delete/{memberId}")
    public String deleteById(@PathVariable String memberId) {
        memberService.deleteById(memberId);
        return "redirect:/member/";
    }
}
