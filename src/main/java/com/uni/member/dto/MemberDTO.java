package com.uni.member.dto;

import com.uni.member.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private String memberId;
    private String memberEmail;
    private String memberPw;
    private String memberName;
    private String memberAddress;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberPw(memberEntity.getMemberPw());
        memberDTO.setMemberAddress(memberEntity.getMemberAddress());
        return memberDTO;
    }
}
