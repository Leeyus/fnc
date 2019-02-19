package com.iu.board.auNotice;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.Pager;

@Service
public class AuNoticeService {
	@Inject
	private AuNoticeDAO auNoticeDAO;
	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView list(Pager pager) throws Exception {
		pager.makeRow();
		int totalCount = auNoticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		ModelAndView mv =new ModelAndView();
		mv.setViewName("board/boardList");
		mv.addObject("list", auNoticeDAO.list(pager));
		mv.addObject("pager", pager);
		
		return mv;
	}
	
	public ModelAndView select(int num)throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = auNoticeDAO.select(num);
		
		if(boardDTO!=null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
		}else {
			mv.setViewName("redirect:./AuditionNoticeList");
		}
		mv.addObject("board", "AuditionNotice");
		return mv;
	}
	
	
	
	public ModelAndView insert(BoardDTO boardDTO,List<MultipartFile> f1, HttpSession session) throws Exception {
		//1.sequence num 가져오기
		int num = auNoticeDAO.getNum();
		
		//2.Notice Table에 insert가 가능
		boardDTO.setNum(num);
		int result = auNoticeDAO.insert(boardDTO);
		
		//transaction 처리
		if(result<1) {
			throw new Exception();
		}
		
		//3. HDD에 File 저장
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/auNotice");//저장 경로 realPath
		
		for(MultipartFile multipartFile :f1) {
			if(multipartFile==null || multipartFile.isEmpty()) {
				continue;
			}
			String fname = fs.saveFile(realPath, multipartFile);
		//4. Files 테이블에 insert
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setKind("u");
			result = fileDAO.insert(fileDTO);
			
			//transaction
			if(result<1) {
				throw new Exception();
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./AuditionNoticeList");
		mv.addObject("msg", "Write Success");
		return mv;
	}
	
	public ModelAndView update(BoardDTO boardDTO,List<MultipartFile> f1, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = auNoticeDAO.update(boardDTO);
		
		if(result<1) {
			throw new Exception();
		}
		//HDD save
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/auNotice");
		for(MultipartFile multipartFile:f1) {
			String fname = fs.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setFname(fname);
			fileDTO.setKind("u");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
			String msg = "Update Success";
		
		mv.setViewName("redirect:./AuditionNoticeSelect?num="+boardDTO.getNum());
		mv.addObject("msg", msg);
		return mv;
	}
	public ModelAndView delete(int num,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		//1.notice Delete
		int result = auNoticeDAO.delete(num);
		if(result<1) {
			throw new Exception();
		}
		
		//2. HDD Delete준비
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(num);
		fileDTO.setKind("u");
		List<FileDTO> ar = fileDAO.list(fileDTO);
		
		//3.Files Delete
		result = fileDAO.deleteAll(fileDTO);
		
		//4. HDD Delete
		String realPath = session.getServletContext().getRealPath("resources/auNotice");
		for(FileDTO fileDTO2:ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		
		mv.setViewName("redirect:./AuditionNoticeList");
		mv.addObject("msg", "Delete Success");
		
		return mv;
	}
	

	
}
