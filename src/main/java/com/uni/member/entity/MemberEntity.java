package com.uni.member.entity;

import com.uni.member.dto.MemberDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {

    @Id
    private String memberId;

    @Column(unique = true)
    private String memberEmail;
    @Column
    private String memberPw;
    @Column
    private String memberName;
    @Column
    private String memberAddress;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberPw(memberDTO.getMemberPw());
        memberEntity.setMemberAddress(memberDTO.getMemberAddress());
        return memberEntity;
    }
}

