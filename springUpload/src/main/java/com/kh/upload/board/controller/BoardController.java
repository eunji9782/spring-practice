package com.kh.upload.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.board.service.BoardService;
import com.kh.upload.vo.BoardVo;

@Controller
@RequestMapping("board")
public class BoardController {
	
	private static BoardService boardService;
	
	
	
	//작성 화면
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	
	//작성 화면
	@PostMapping("write")
	public String write(BoardVo vo, HttpServletRequest req) {
		
		
		//파일 저장
		MultipartFile[] f = vo.getF();
		
		//파일 확인
		if(!f[0].isEmpty()) {//파일 있음
			for(int i = 0; i < f.length; i++) {
				//원본 파일명
				String originName = f[i].getOriginalFilename();
				String ext = originName.substring(originName.lastIndexOf(".")); //확장자
				
				//파일이름 변경하기
				long now = System.currentTimeMillis();
				int randomNum = (int)(Math.random() * 90000 + 10000);
				
				String changeName = now + "_" + randomNum;
				
				//파일 객체 생성
				String rootPath = req.getServletContext().getRealPath("/resources/upload/");
				File targerFile = new File(rootPath + changeName + ext);
				
				//저장
				try {
					f[i].transferTo(targerFile); //경로에 이동
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
		}
		
		
		return "board/write";
	}

}
